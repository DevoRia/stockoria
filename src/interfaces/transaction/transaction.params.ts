export interface TransactionInputWhereParams {
  id?: number
  createdAt?: Date | string
  updatedAt?: Date | string
  value?: number
  usd_value?: number
  description?: string | null
  currencyId?: number
  accountId?: number
  status?: string
  type?: string
}
