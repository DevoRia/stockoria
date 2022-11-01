import { Injectable, NestMiddleware } from '@nestjs/common';
import { Response, NextFunction } from 'express';
import {AuthService} from "./auth.service";
import {IRequest} from "./contracts/common";

@Injectable()
export class AuthMiddleware implements NestMiddleware {

    constructor(private authService: AuthService) {
    }

    use(req: IRequest, res: Response, next: NextFunction) {
        req.userData = this.authService.decodeJwtFromRequest(req);
        next();
    }
}
