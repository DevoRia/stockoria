import { Injectable } from '@nestjs/common';
import { ConfigService } from '@nestjs/config';

@Injectable()
export class AuthConfig {
  constructor(private config: ConfigService) {
  }

  get() {
    const userPoolId: string = this.config.getOrThrow('COGNITO_USER_POOL_ID');
    const clientId: string = this.config.getOrThrow('COGNITO_CLIENT_ID');
    const region: string = this.config.getOrThrow('COGNITO_REGION');

    return {
      userPoolId,
      clientId,
      region,
      authority: `https://cognito-idp.${process.env.COGNITO_REGION}.amazonaws.com/${process.env.COGNITO_USER_POOL_ID}`,
    };
  }
}
