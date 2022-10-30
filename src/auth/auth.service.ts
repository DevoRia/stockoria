import { ForbiddenException, Injectable } from '@nestjs/common';
import * as argon from 'argon2';
import { JwtService } from '@nestjs/jwt';
import { ConfigService } from '@nestjs/config';
import { AuthDTO } from './dto/AuthDTO';
import { PrismaService } from '../prisma/prisma.service';

@Injectable()
export class AuthService {
  constructor(
    private prisma: PrismaService,
    private config: ConfigService,
    private jwtService: JwtService,
  ) {
  }

  async createUser(dto: AuthDTO) {
    const hash = await argon.hash(dto.password);
    return this.prisma.user.create({
      data: {
        email: dto.email,
        hash,
      },
    });
  }

  async signIn(dto: AuthDTO) {
    const user = await this.prisma.user.findFirst({
      where: {
        email: dto.email,
      },
    });
    if (!user) {
      throw new ForbiddenException('Invalid credentials');
    }

    const pwMatches = await argon.verify(
      user.hash,
      dto.password,
    );
    if (!pwMatches) {
      throw new ForbiddenException(
        'Credentials incorrect',
      );
    }
    return this.verifyToken(user.id, user.email);
  }

  async verifyToken(userId, email) {
    const payload = {
      userId,
      email,
    };
    return this.jwtService.signAsync(payload, {
      expiresIn: '15m',
      secret: this.config.get('JWT_SECRET'),
    });
  }
}
