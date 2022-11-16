import { Injectable } from '@nestjs/common';
import { PrismaService } from '../prisma/prisma.service';
import { User } from '../../interfaces/user/user.interface';
import { TransactionDto } from './dto/transaction.dto';
import { TransactionStatus, TransactionType } from '../../interfaces/transaction/transaction.interface';

@Injectable()
export class TransactionService {
  constructor(
    private readonly prisma: PrismaService,
  ) {}

  income(dto: TransactionDto, { username } : User) {
    return this.prisma.transaction.create({
      data: {
        ...dto,
        usd_value: dto.value,
        status: TransactionStatus.COMPLETE,
        type: TransactionType.INCOME,
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
