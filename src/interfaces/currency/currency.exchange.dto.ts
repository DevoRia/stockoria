export interface CurrencyExchangeDto {
  from: string;
  to: string;
  amount?: number;
}

export interface SuccessConvertResponse {
  success: boolean,
  query: {
    from: string,
    to: string,
    amount: number
  },
  info: {
    timestamp: number,
    rate: number
  },
  date: Date,
  result: number
}

export interface FailedConvertResponse {
  error: { code: string, message: string }
}
