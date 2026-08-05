import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class FundTransferService {
    balance:number = 1000;

  constructor() { }

  transferFunds(
    senderBalance: number,
    transferAmount: number
  ): string {

    if (transferAmount <= 0) {
      return "Transfer amount should be greater than zero.";
    }

    if (senderBalance < transferAmount) {
      return "Insufficient Balance.";
    }

    senderBalance -= transferAmount;

    this.balance -= transferAmount;

    return `Fund Transfer Successful.
Remaining Balance: ₹${senderBalance}`;
  }

  getBalance():number{
    return this.balance;
  }
}