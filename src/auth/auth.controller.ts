import {
  Body, Controller, Get, Post,
} from '@nestjs/common';
import { AuthService } from './auth.service';
import { AuthDTO } from './dto/AuthDTO';

@Controller('api/auth')
export class AuthController {
  constructor(private authService: AuthService) {
  }

  @Post()
  createUser(@Body() dto: AuthDTO) {
    return this.authService.authenticateUser(dto);
  }
}
