import { Router } from "express";
import { AccountController } from "../controllers/accountController";

const router = Router();

const accountController = new AccountController();

router.post("/deposit", (req, res) => {
    accountController.deposit(req, res);
});

router.post("/withdraw", (req, res) => {
    accountController.withdraw(req, res);
});

export default router;