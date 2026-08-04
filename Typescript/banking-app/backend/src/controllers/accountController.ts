import { Request, Response } from "express";
import { Account } from "../models/account";
import { AccountService } from "../services/accountService";

export class AccountController {

    private accountService = new AccountService();

    deposit(req: Request, res: Response): void {

        const account: Account = req.body.account;
        const amount: number = req.body.amount;

        const updatedAccount = this.accountService.deposit(account, amount);

        res.status(200).json(updatedAccount);
    }

    withdraw(req: Request, res: Response): void {

        const account: Account = req.body.account;
        const amount: number = req.body.amount;

        const updatedAccount = this.accountService.withdraw(account, amount);

        res.status(200).json(updatedAccount);
    }
}