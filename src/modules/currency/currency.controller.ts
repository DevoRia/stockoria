import {
  Body, Controller, Post, UseGuards,
} from '@nestjs/common';
import { JwtGuard } from '../auth/guard/auth.guard';
import { CurrencyService } from './currency.service';
import { CurrencyDto } from './currency.dto';
import { ExchangeRateService } from '../../integration/exchange-rate.service';
import { CurrencyExchangeDto } from '../../interfaces/currency/currency.exchange.dto';

@Controller('api/currency')
export class CurrencyController {
  constructor(
    private currencyService: CurrencyService,
    private exchangeRateService: ExchangeRateService,
  ) {
  }

  @Post()
  @UseGuards(JwtGuard)
  create(@Body() dto: CurrencyDto) {
    return this.currencyService.create(dto);
  }

  @Post('convert')
  @UseGuards(JwtGuard)
  convertAxios(@Body() dto: CurrencyExchangeDto) {
    return this.exchangeRateService.convertCurrency(dto);
  }
}
