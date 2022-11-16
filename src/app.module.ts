import { Module } from '@nestjs/common';
import { ConfigModule } from '@nestjs/config';
import { AuthModule } from './modules/auth/auth.module';
import { UserModule } from './modules/user/user.module';
import { PrismaModule } from './modules/prisma/prisma.module';
import { HealthController } from './health.controller';
import { FundModule } from './modules/fund/fund.module';
import { CurrencyModule } from './modules/currency/currency.module';
import { TransactionModule } from './modules/transaction/transaction.module';

@Module({
  imports: [
    ConfigModule.forRoot({ isGlobal: true }),
    AuthModule,
    FundModule,
    CurrencyModule,
    TransactionModule,
    UserModule,
    PrismaModule,
  ],
  controllers: [
    HealthController,
  ],

})
export class AppModule {}
