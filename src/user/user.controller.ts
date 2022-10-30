import { Controller, Get, UseGuards } from '@nestjs/common';
import { JwtGuard } from '../auth/guard/auth.guard';

@Controller('user')
export class UserController {
  @Get('me')
  @UseGuards(JwtGuard)
  getMe() {
    return "it's me";
  }
}