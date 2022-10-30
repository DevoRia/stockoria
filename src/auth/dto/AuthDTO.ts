import { IsNotEmpty, IsString } from 'class-validator';

export class AuthDTO {
  @IsNotEmpty()
  @IsString()
    username: string;

  @IsString()
  @IsNotEmpty()
    password: string;
}
