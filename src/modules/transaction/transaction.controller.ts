import {
  Body, Controller, Get, Post, Query, Req, UseGuards,
} from '@nestjs/common';
import { JwtGuard } from '../auth/guard/auth.guard';
import { IRequest } from '../auth/contracts/common';
import { TransactionService } from './transaction.service';
import { TransactionDto } from './dto/transaction.dto';
import { TransactionType } from '../../interfaces/transaction/transaction.interface';

@Controller('api/transaction')
export class TransactionController {
  constructor(private transactionService: TransactionService) {
  }

  @Get()
  @UseGuards(JwtGuard)
  findAll(@Req() req: IRequest) {
    return this.transactionService.findAll(req.userData);
  }

  @Get('sum')
  @UseGuards(JwtGuard)
  sum(@Query('currency') currency: string, @Req() req: IRequest) {
    if (!currency) {
      return this.transactionService.sum(req.userData);
    }

    return this.transactionService.sumTotal(req.userData, currency);
  }

  @Post()
  @UseGuards(JwtGuard)
  income(@Body() dto: TransactionDto, @Req() req: IRequest) {
    return this.transactionService.transaction(dto, req.userData);
  }

  @Post('/expense')
  @UseGuards(JwtGuard)
  expense(@Body() dto: TransactionDto, @Req() req: IRequest) {
    return this.transactionService.transaction(dto, req.userData, TransactionType.EXPENSE);
  }
}
