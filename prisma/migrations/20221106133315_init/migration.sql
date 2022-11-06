-- CreateTable
CREATE TABLE "users" (
    "id" SERIAL NOT NULL,
    "createdAt" TIMESTAMP(3) NOT NULL DEFAULT CURRENT_TIMESTAMP,
    "updatedAt" TIMESTAMP(3) NOT NULL,
    "email" TEXT,
    "username" TEXT NOT NULL,
    "firstName" TEXT,
    "lastName" TEXT,

    CONSTRAINT "users_pkey" PRIMARY KEY ("id")
);

-- CreateTable
CREATE TABLE "valutes" (
    "id" SERIAL NOT NULL,
    "createdAt" TIMESTAMP(3) NOT NULL DEFAULT CURRENT_TIMESTAMP,
    "updatedAt" TIMESTAMP(3) NOT NULL,
    "short" TEXT NOT NULL,
    "icon" TEXT NOT NULL,
    "description" TEXT,

    CONSTRAINT "valutes_pkey" PRIMARY KEY ("id")
);

-- CreateTable
CREATE TABLE "valute-exchanges" (
    "id" SERIAL NOT NULL,
    "createdAt" TIMESTAMP(3) NOT NULL DEFAULT CURRENT_TIMESTAMP,
    "updatedAt" TIMESTAMP(3) NOT NULL,
    "valuteId" INTEGER NOT NULL,
    "valuteToConvertId" INTEGER NOT NULL,
    "value_buy" INTEGER NOT NULL,
    "value_sell" INTEGER NOT NULL,

    CONSTRAINT "valute-exchanges_pkey" PRIMARY KEY ("id")
);

-- CreateTable
CREATE TABLE "transactions" (
    "id" SERIAL NOT NULL,
    "createdAt" TIMESTAMP(3) NOT NULL DEFAULT CURRENT_TIMESTAMP,
    "updatedAt" TIMESTAMP(3) NOT NULL,
    "value" INTEGER NOT NULL,
    "usd_value" INTEGER NOT NULL,
    "description" TEXT,
    "valuteId" INTEGER NOT NULL,
    "status" TEXT NOT NULL,
    "type" TEXT NOT NULL,
    "userId" INTEGER NOT NULL,

    CONSTRAINT "transactions_pkey" PRIMARY KEY ("id")
);

-- CreateTable
CREATE TABLE "totals" (
    "id" SERIAL NOT NULL,
    "createdAt" TIMESTAMP(3) NOT NULL DEFAULT CURRENT_TIMESTAMP,
    "updatedAt" TIMESTAMP(3) NOT NULL,
    "from" TIMESTAMP(3) NOT NULL,
    "to" TIMESTAMP(3) NOT NULL,
    "value" INTEGER NOT NULL,
    "type" TEXT NOT NULL,
    "valuteId" INTEGER NOT NULL,
    "userId" INTEGER NOT NULL,

    CONSTRAINT "totals_pkey" PRIMARY KEY ("id")
);

-- CreateTable
CREATE TABLE "fund" (
    "id" SERIAL NOT NULL,
    "createdAt" TIMESTAMP(3) NOT NULL DEFAULT CURRENT_TIMESTAMP,
    "updatedAt" TIMESTAMP(3) NOT NULL,
    "title" INTEGER NOT NULL,
    "description" TEXT,
    "userId" INTEGER NOT NULL,

    CONSTRAINT "fund_pkey" PRIMARY KEY ("id")
);

-- CreateTable
CREATE TABLE "fund-transactions" (
    "id" SERIAL NOT NULL,
    "createdAt" TIMESTAMP(3) NOT NULL DEFAULT CURRENT_TIMESTAMP,
    "updatedAt" TIMESTAMP(3) NOT NULL,
    "value" INTEGER NOT NULL,
    "usd_value" INTEGER NOT NULL,
    "description" TEXT,
    "valuteId" INTEGER NOT NULL,
    "status" TEXT NOT NULL,
    "type" TEXT NOT NULL,
    "userId" INTEGER NOT NULL,

    CONSTRAINT "fund-transactions_pkey" PRIMARY KEY ("id")
);

-- CreateIndex
CREATE UNIQUE INDEX "users_username_key" ON "users"("username");

-- CreateIndex
CREATE UNIQUE INDEX "users_email_username_key" ON "users"("email", "username");

-- CreateIndex
CREATE UNIQUE INDEX "valutes_short_icon_key" ON "valutes"("short", "icon");

-- AddForeignKey
ALTER TABLE "valute-exchanges" ADD CONSTRAINT "valute-exchanges_valuteId_fkey" FOREIGN KEY ("valuteId") REFERENCES "valutes"("id") ON DELETE RESTRICT ON UPDATE CASCADE;

-- AddForeignKey
ALTER TABLE "valute-exchanges" ADD CONSTRAINT "valute-exchanges_valuteToConvertId_fkey" FOREIGN KEY ("valuteToConvertId") REFERENCES "valutes"("id") ON DELETE RESTRICT ON UPDATE CASCADE;

-- AddForeignKey
ALTER TABLE "transactions" ADD CONSTRAINT "transactions_valuteId_fkey" FOREIGN KEY ("valuteId") REFERENCES "valutes"("id") ON DELETE RESTRICT ON UPDATE CASCADE;

-- AddForeignKey
ALTER TABLE "transactions" ADD CONSTRAINT "transactions_userId_fkey" FOREIGN KEY ("userId") REFERENCES "users"("id") ON DELETE RESTRICT ON UPDATE CASCADE;

-- AddForeignKey
ALTER TABLE "totals" ADD CONSTRAINT "totals_valuteId_fkey" FOREIGN KEY ("valuteId") REFERENCES "valutes"("id") ON DELETE RESTRICT ON UPDATE CASCADE;

-- AddForeignKey
ALTER TABLE "totals" ADD CONSTRAINT "totals_userId_fkey" FOREIGN KEY ("userId") REFERENCES "users"("id") ON DELETE RESTRICT ON UPDATE CASCADE;

-- AddForeignKey
ALTER TABLE "fund" ADD CONSTRAINT "fund_userId_fkey" FOREIGN KEY ("userId") REFERENCES "users"("id") ON DELETE RESTRICT ON UPDATE CASCADE;

-- AddForeignKey
ALTER TABLE "fund-transactions" ADD CONSTRAINT "fund-transactions_valuteId_fkey" FOREIGN KEY ("valuteId") REFERENCES "valutes"("id") ON DELETE RESTRICT ON UPDATE CASCADE;

-- AddForeignKey
ALTER TABLE "fund-transactions" ADD CONSTRAINT "fund-transactions_userId_fkey" FOREIGN KEY ("userId") REFERENCES "users"("id") ON DELETE RESTRICT ON UPDATE CASCADE;
