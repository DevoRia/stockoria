import { MiddlewareConsumer, Module } from '@nestjs/common';
import { AuthMiddleware } from '../auth/auth.middleware';
import { TransactionController } from './transaction.controller';
import { TransactionService } from './transaction.service';

@Module({
  controllers: [TransactionController],
  providers: [TransactionService],
})
export class TransactionModule {
  configure(consumer: MiddlewareConsumer) {
    consumer.apply(AuthMiddleware).forRoutes(TransactionController);
  }
}
