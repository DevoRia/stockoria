import { Injectable } from '@nestjs/common';
import { PrismaService } from '../prisma/prisma.service';
import { CurrencyDto } from './currency.dto';

@Injectable()
export class CurrencyService {
  constructor(
    private readonly prisma: PrismaService,
  ) {}

  create(data: CurrencyDto) {
    return this.prisma.currency.create({ data });
  }

  convert() {

  }
}
