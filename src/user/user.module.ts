import {MiddlewareConsumer, Module} from '@nestjs/common';
import { UserController } from './user.controller';
import { UserService } from './user.service';
import {AuthMiddleware} from "../auth/auth.middleware";
import {AuthModule} from "../auth/auth.module";

@Module({
  controllers: [UserController],
  providers: [UserService],
})
export class UserModule {
  configure(consumer: MiddlewareConsumer) {
    consumer.apply(AuthMiddleware).forRoutes(UserController);
  }
}
