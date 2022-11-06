import { MiddlewareConsumer, Module } from '@nestjs/common';
import { AuthMiddleware } from '../auth/auth.middleware';
import { FundController } from './fund.controller';
import { FundService } from './fund.service';

@Module({
  controllers: [FundController],
  providers: [FundService],
})
export class FundModule {
  configure(consumer: MiddlewareConsumer) {
    consumer.apply(AuthMiddleware).forRoutes(FundController);
  }
}
