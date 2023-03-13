import { AccountType } from '../../../interfaces/account/account.interface';

export interface AccountDto {
  title: string;
  description?: string;
  address : string;
  provider? : string;
  network? : string;
  legalEntity: string;
  currency: string;
  type: AccountType;

}
