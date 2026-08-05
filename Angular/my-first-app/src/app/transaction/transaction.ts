import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { FundTransferService } from '../services/fund-transfer.service';

@Component({
    selector: 'app-transaction',
    standalone: true,
    imports: [FormsModule],   // <-- This is required
    templateUrl: './transaction.html',
    styleUrl: './transaction.css'
})
export class Transaction {

    balance = 10000;
    amount = 0;
    message = '';

    constructor(private fundTransferService: FundTransferService) {
        this.balance = this.fundTransferService.getBalance();
    }

    transfer() {
        this.message = this.fundTransferService.transferFunds(
            this.balance,
            this.amount
        );

        this.balance = this.fundTransferService.getBalance();
    }
}