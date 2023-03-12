import { MiddlewareConsumer, Module } from '@nestjs/common';
import { AuthMiddleware } from '../auth/auth.middleware';
import { TransactionController } from './transaction.controller';
import { TransactionService } from './transaction.service';
import { IntegrationModule } from '../../integration/integration.module';

@Module({
  controllers: [TransactionController],
  imports: [IntegrationModule],
  providers: [TransactionService],
})
export class TransactionModule {
  configure(consumer: MiddlewareConsumer) {
    consumer.apply(AuthMiddleware).forRoutes(TransactionController);
  }
}
