import {
  Body, Controller, Get, Post,
} from '@nestjs/common';
import { AuthService } from './auth.service';
import { AuthDTO } from './dto/AuthDTO';

@Controller('auth')
export class AuthController {
  constructor(private authService: AuthService) {
  }

  @Get('user')
  getUser(@Body() dto: AuthDTO) {
    return this.authService.signIn(dto);
  }

  @Post('user')
  createUser(@Body() dto: AuthDTO) {
    return this.authService.createUser(dto);
  }
}
