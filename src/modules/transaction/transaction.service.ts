import { Injectable } from '@nestjs/common';
import { PrismaService } from '../prisma/prisma.service';
import { User } from '../../interfaces/user/user.interface';
import { TransactionDto } from './dto/transaction.dto';
import {
  TransactionStatus,
  TransactionType,
} from '../../interfaces/transaction/transaction.interface';
import { ExchangeRateService } from '../../integration/exchange-rate.service';

@Injectable()
export class TransactionService {
  constructor(
    private readonly prisma: PrismaService,
    private readonly exchangeRateService: ExchangeRateService,
  ) {}

  findAll({ username } : User) {
    return this.prisma.transaction.findMany({
      where: {
        user: {
          is: {
            username,
          },
        },
      },
      include: {
        currency: true,
      },
    });
  }

  async sum(user: User) {
    const all = await this.findAll(user);
    return all.reduce(
      (total, transaction) => (transaction.type === TransactionType.INCOME
        ? total + transaction.value
        : total - transaction.value),
      0,
    );
  }

  async sumTotal(user: User, currency: string) {
    const groupedTransactions = {};
    const all = await this.findAll(user);

    all.forEach((transaction) => {
      if (!groupedTransactions[transaction.currency.short]) {
        groupedTransactions[transaction.currency.short] = 0;
      }

      if (transaction.type === TransactionType.INCOME) {
        groupedTransactions[transaction.currency.short] += transaction.value;
      } else {
        groupedTransactions[transaction.currency.short] -= transaction.value;
      }
    });

    return (await Promise.all(Object.entries(groupedTransactions)
      .map(async ([currencyMapped, value]: [string, number]) => {
        if (currencyMapped === currency) {
          return Promise.resolve(value);
        }

        const { value: convertedValue } = await this.exchangeRateService.convertCurrency({
          amount: Math.abs(value),
          from: currencyMapped,
          to: currency,
        });

        return value < 0 ? -convertedValue : convertedValue;
      }))).reduce((previousValue, value) => previousValue + value, 0);
  }

  transaction(
    dto: TransactionDto,
    { username } : User,
    type: TransactionType = TransactionType.INCOME,
  ) {
    return this.prisma.transaction.create({
      data: {
        ...dto,
        usd_value: dto.value,
        status: TransactionStatus.COMPLETE,
        type,
        currency: {
          connect: {
            short: dto.currency,
          },
        },
        user: {
          connect: {
            username,
          },
        },
      },
    });
  }
}
