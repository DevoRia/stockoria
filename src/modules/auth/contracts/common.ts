import { Request } from 'express';
import { User } from '../../../interfaces/user/user.interface';

export type IRequest = Request & { userData: User };

export interface Token {
  'cognito:username': string,
  email: string
}
