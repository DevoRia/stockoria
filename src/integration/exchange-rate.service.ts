import { Injectable } from '@nestjs/common';
import { HttpService } from '@nestjs/axios';
import { ConfigService } from '@nestjs/config';
import { lastValueFrom } from 'rxjs';
import {
  CurrencyExchangeDto, FailedConvertResponse,
  SuccessConvertResponse,
} from '../interfaces/currency/currency.exchange.dto';

@Injectable()
export class ExchangeRateService {
  private readonly API_KEY;

  constructor(
    private readonly httpService: HttpService,
    private readonly config: ConfigService,
  ) {
    this.API_KEY = this.config.getOrThrow('EXCHANGE_API_KEY');
  }

  async convertCurrency({ amount, from, to }: CurrencyExchangeDto) {
    const url = `https://api.apilayer.com/exchangerates_data/convert?from=${from}&to=${to}&amount=${amount || 1}`;
    const observable = this.httpService.get<SuccessConvertResponse | FailedConvertResponse>(url, {
      headers: {
        apikey: this.API_KEY,
      },
    });
    const result = await lastValueFrom(observable);

    if ('error' in result.data) {
      throw new Error(result.data.error.message);
    }

    return {
      value: result.data.result,
      date: result.data.date,
      from: result.data.query.from,
      to: result.data.query.to,
      amount: result.data.query.amount,
    };
  }
}
