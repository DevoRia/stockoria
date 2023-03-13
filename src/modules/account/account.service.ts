import { Injectable } from '@nestjs/common';
import { AccountDto } from './dto/account.dto';
import { PrismaService } from '../prisma/prisma.service';
import { User } from '../../interfaces/user/user.interface';

@Injectable()
export class AccountService {
  constructor(
    private readonly prisma: PrismaService,
  ) {}

  async fetch({ username } : User) {
    return this.prisma.account.findMany({
      where: {
        user: {
          is: {
            username,
          },
        },
      },
    });
  }

  async fetchById(id: number, { username } : User) {
    return this.prisma.account.findFirst({
      where: {
        id,
        user: {
          is: {
            username,
          },
        },
      },
    });
  }

  async create(dto: AccountDto, { username } : User) {
    return this.prisma.account.create({
      data: {
        ...dto,
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

  async update(id: number, dto: Partial<AccountDto>, { username } : User) {
    return this.prisma.account.update({
      where: {
        id,
      },
      data: {
        ...dto,
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

  async softRemove(id: number, { username } : User) {
    return '';
  }
}
