import { Injectable } from '@nestjs/common';
import { FundDto } from './dto/fund.dto';
import { PrismaService } from '../prisma/prisma.service';
import { User } from '../interfaces/user/user.interface';

@Injectable()
export class FundService {
  constructor(
    private readonly prisma: PrismaService,
  ) {}

  async fetch({ username } : User) {
    return this.prisma.fund.findMany({
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
    return this.prisma.fund.findFirst({
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

  async create(dto: FundDto, { username } : User) {
    return this.prisma.fund.create({
      data: {
        ...dto,
        user: {
          connect: {
            username,
          },
        },
      },
    });
  }

  async update(id: number, dto: Partial<FundDto>, { username } : User) {
    return this.prisma.fund.update({
      where: {
        id,
      },
      data: {
        ...dto,
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
