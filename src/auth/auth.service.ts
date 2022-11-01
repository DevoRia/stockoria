import { ForbiddenException, Injectable } from '@nestjs/common';
import {
  AuthenticationDetails,
  CognitoUser,
  CognitoUserPool,
} from 'amazon-cognito-identity-js';
import { Request } from 'express';

import jwtDecode from 'jwt-decode';
import { AuthConfig } from './auth.config';
import { PrismaService } from '../prisma/prisma.service';
import { AuthDto } from './dto/auth.dto';
import {IRequest, Token} from './contracts/common';

@Injectable()
export class AuthService {
  private readonly userPool: CognitoUserPool;

  constructor(
    private readonly authConfig: AuthConfig,
    private readonly prisma: PrismaService,
  ) {
    const cognitoConfig = authConfig.get();
    this.userPool = new CognitoUserPool({
      UserPoolId: cognitoConfig.userPoolId,
      ClientId: cognitoConfig.clientId,
    });
  }

  decodeJwtFromRequest(request: IRequest) {
    const decoded: Token = jwtDecode(request.headers.authorization);

    return {
      username: decoded['cognito:username'],
      email: decoded.email,
    };
  }

  authenticateUser(user: AuthDto) {
    const { username, password } = user;

    const authenticationDetails = new AuthenticationDetails({
      Username: username,
      Password: password,
    });

    const userData = {
      Username: username,
      Pool: this.userPool,
    };

    const newUser = new CognitoUser(userData);

    return new Promise((resolve, reject) => newUser.authenticateUser(authenticationDetails, {
      onSuccess: async (result) => {
        const username = result.getIdToken().payload['cognito:username'];
        await this.prisma.user.upsert(
          {
            where: {
              username,
            },
            update: {},
            create: {
              username,
            },
          },
        );
        resolve(result);
      },
      onFailure: (err) => {
        reject(err);
      },
      newPasswordRequired: (
        userAttributes: any,
        requiredAttributes: any,
      ) => {
        newUser.completeNewPasswordChallenge(
          authenticationDetails.getPassword(),
          {},
          {
            onSuccess: (user) => {
              resolve(user);
            },
            onFailure: (error) => {
              reject(error);
            },
          },
        );
      },
    }));
  }
}
