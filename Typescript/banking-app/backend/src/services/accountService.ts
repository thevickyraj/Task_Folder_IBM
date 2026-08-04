import { Account } from "../models/account";

export class AccountService {

    // Deposit Money
    deposit(account: Account, amount: number): Account {

        if (amount <= 0) {
            console.log("Invalid Deposit Amount");
            return account;
        }

        account.balance += amount;

        console.log(`₹${amount} deposited successfully.`);
        console.log(`Available Balance: ₹${account.balance}`);

        return account;
    }

    // Withdraw Money
    withdraw(account: Account, amount: number): Account {

        if (amount <= 0) {
            console.log("Invalid Withdrawal Amount");
            return account;
        }

        if (amount > account.balance) {
            console.log("Insufficient Balance");
            return account;
        }

        account.balance -= amount;

        console.log(`₹${amount} withdrawn successfully.`);
        console.log(`Available Balance: ₹${account.balance}`);

        return account;
    }

}