import { MiddlewareConsumer, Module } from '@nestjs/common';
import { AuthMiddleware } from '../auth/auth.middleware';
import { CurrencyController } from './currency.controller';
import { CurrencyService } from './currency.service';

@Module({
  controllers: [CurrencyController],
  providers: [CurrencyService],
})
export class CurrencyModule {
  configure(consumer: MiddlewareConsumer) {
    consumer.apply(AuthMiddleware).forRoutes(CurrencyController);
  }
}
