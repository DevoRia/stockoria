import {User} from "../../interfaces/user/user.interface";
import { Request } from 'express';

export type IRequest = Request & { userData: User };
