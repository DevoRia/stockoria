import { Module } from '@nestjs/common';
import { ConfigModule } from '@nestjs/config';
import { AuthModule } from './auth/auth.module';
import { UserModule } from './user/user.module';
import { PrismaModule } from './prisma/prisma.module';
import { HealthController } from './health.controller';
import { FundModule } from './fund/fund.module';
import { CurrencyModule } from './currency/currency.module';
import { TransactionModule } from './transaction/transaction.module';

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
