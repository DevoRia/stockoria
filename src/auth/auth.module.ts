import {Global, Module} from '@nestjs/common';
import { JwtModule } from '@nestjs/jwt';
import { AuthController } from './auth.controller';
import { AuthService } from './auth.service';
import { JwtStrategy } from './strategy/jwt.strategy';
import { JwtGuard } from './guard/auth.guard';
import { AuthConfig } from './auth.config';
import {AuthMiddleware} from "./auth.middleware";

@Global()
@Module({
  imports: [JwtModule.register({})],
  controllers: [AuthController],
  providers: [AuthService, JwtStrategy, JwtGuard, AuthConfig, AuthMiddleware],
  exports: [JwtGuard, AuthService, AuthMiddleware],
})
export class AuthModule {

}
