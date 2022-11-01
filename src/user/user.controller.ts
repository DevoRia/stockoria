import {Controller, Get, Req, UseGuards} from '@nestjs/common';
import { JwtGuard } from '../auth/guard/auth.guard';
import {IRequest} from "../auth/contracts/common";

@Controller('api/user')
export class UserController {
  @Get('me')
  @UseGuards(JwtGuard)
  getMe(@Req() req: IRequest) {
    return req.userData;
  }
}
