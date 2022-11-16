import {
  Body,
  Controller, Delete, Get, Param, Patch, Post, Req, UseGuards,
} from '@nestjs/common';
import { JwtGuard } from '../auth/guard/auth.guard';
import { IRequest } from '../auth/contracts/common';
import { FundDto } from './dto/fund.dto';
import { FundService } from './fund.service';

@Controller('api/fund')
export class FundController {
  constructor(private fundService: FundService) {
  }

  @Get()
  @UseGuards(JwtGuard)
  getFunds(@Req() req: IRequest) {
    return this.fundService.fetch(req.userData);
  }

  @Get(':id')
  @UseGuards(JwtGuard)
  getFundById(@Param('id') id, @Req() req: IRequest) {
    if (!Number(id)) {
      throw new Error('id must be a number');
    }

    return this.fundService.fetchById(Number(id), req.userData);
  }

  @Post()
  @UseGuards(JwtGuard)
  create(@Body() dto: FundDto, @Req() req: IRequest) {
    return this.fundService.create(dto, req.userData);
  }

  @Patch(':id')
  @UseGuards(JwtGuard)
  update(@Body() dto: Partial<FundDto>, @Param('id') id, @Req() req: IRequest) {
    if (!Number(id)) {
      throw new Error('id must be a number');
    }

    return this.fundService.update(Number(id), dto, req.userData);
  }

  @Delete(':id')
  @UseGuards(JwtGuard)
  delete(@Param('id') id, @Req() req: IRequest) {
    if (!Number(id)) {
      throw new Error('id must be a number');
    }

    return this.fundService.softRemove(Number(id), req.userData);
  }
}
