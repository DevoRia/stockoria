import {
  Body,
  Controller, Post, Put, Req, UseGuards,
} from '@nestjs/common';
import { JwtGuard } from '../auth/guard/auth.guard';
import { IRequest } from '../auth/contracts/common';
import { CurrencyService } from './currency.service';
import { CurrencyDto } from './currency.dto';

@Controller('api/currency')
export class CurrencyController {
  constructor(private currencyService: CurrencyService) {
  }

  @Post()
  @UseGuards(JwtGuard)
  create(@Body() dto: CurrencyDto, @Req() req: IRequest) {
    return this.currencyService.create(dto);
  }
}
