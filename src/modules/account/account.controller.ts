import {
  Body,
  Controller, Delete, Get, Param, Patch, Post, Req, UseGuards,
} from '@nestjs/common';
import { JwtGuard } from '../auth/guard/auth.guard';
import { IRequest } from '../auth/contracts/common';
import { AccountDto } from './dto/account.dto';
import { AccountService } from './account.service';

@Controller('api/account')
export class AccountController {
  constructor(private accountService: AccountService) {
  }

  @Get()
  @UseGuards(JwtGuard)
  getAccounts(@Req() req: IRequest) {
    return this.accountService.fetch(req.userData);
  }

  @Get(':id')
  @UseGuards(JwtGuard)
  getAccountById(@Param('id') id, @Req() req: IRequest) {
    if (!Number(id)) {
      throw new Error('id must be a number');
    }

    return this.accountService.fetchById(Number(id), req.userData);
  }

  @Post()
  @UseGuards(JwtGuard)
  create(@Body() dto: AccountDto, @Req() req: IRequest) {
    return this.accountService.create(dto, req.userData);
  }

  @Patch(':id')
  @UseGuards(JwtGuard)
  update(@Body() dto: Partial<AccountDto>, @Param('id') id, @Req() req: IRequest) {
    if (!Number(id)) {
      throw new Error('id must be a number');
    }

    return this.accountService.update(Number(id), dto, req.userData);
  }

  @Delete(':id')
  @UseGuards(JwtGuard)
  delete(@Param('id') id, @Req() req: IRequest) {
    if (!Number(id)) {
      throw new Error('id must be a number');
    }

    return this.accountService.softRemove(Number(id), req.userData);
  }
}
