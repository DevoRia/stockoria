import { Module } from '@nestjs/common';
import { HttpModule } from '@nestjs/axios';
import { ExchangeRateService } from './exchange-rate.service';

@Module({
  imports: [HttpModule],
  exports: [ExchangeRateService],
  providers: [ExchangeRateService],
})
export class IntegrationModule {
}
