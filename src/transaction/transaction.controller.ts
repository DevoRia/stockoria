import {
  Body,
  Controller, Post, Put, Req, UseGuards,
} from '@nestjs/common';
import { JwtGuard } from '../auth/guard/auth.guard';
import { IRequest } from '../auth/contracts/common';
import { TransactionService } from './transaction.service';
import { TransactionDto } from './dto/transaction.dto';

@Controller('api/transaction')
export class TransactionController {
  constructor(private transactionService: TransactionService) {
  }

  @Post()
  @UseGuards(JwtGuard)
  income(@Body() dto: TransactionDto, @Req() req: IRequest) {
    return this.transactionService.income(dto, req.userData);
  }
}
