import React, { useState } from "react";
import { useDispatch, useSelector } from "react-redux";
import BalanceController from "./BalanceController";

export default function BalanceControls() {
  const [amount, setAmount] = useState(100);
  const [message, setMessage] = useState("");
  const dispatch = useDispatch();
  const balance = useSelector((state) => state.balance);
  const controller = new BalanceController(dispatch);

  const handleDeposit = () => {
    const value = Number(amount);
    if (Number.isNaN(value) || value <= 0) {
      setMessage("Enter a valid amount greater than 0 to deposit.");
      return;
    }
    controller.deposit(value);
    setMessage(`Deposited ₹${value.toFixed(2)} successfully.`);
  };

  const handleWithdraw = () => {
    const value = Number(amount);
    if (Number.isNaN(value) || value <= 0) {
      setMessage("Enter a valid amount greater than 0 to withdraw.");
      return;
    }
    if (value > balance) {
      setMessage("Insufficient balance for this withdrawal.");
      return;
    }
    controller.withdraw(value);
    setMessage(`Withdrew ₹${value.toFixed(2)} successfully.`);
  };

  return (
    <div style={{ marginTop: 12 }}>
      <label>
        Amount:
        <input
          type="number"
          value={amount}
          onChange={(e) => setAmount(Number(e.target.value))}
          style={{ width: 120, marginLeft: 8 }}
        />
      </label>
      <div style={{ marginTop: 8 }}>
        <button onClick={handleDeposit}>Deposit</button>
        <button onClick={handleWithdraw} style={{ marginLeft: 8 }}>
          Withdraw
        </button>
      </div>
      {message && <p style={{ color: "#333", marginTop: 10 }}>{message}</p>}
    </div>
  );
}
