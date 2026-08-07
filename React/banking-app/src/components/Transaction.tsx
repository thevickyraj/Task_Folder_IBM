import { useReducer , useState } from "react";
import "./Transaction.css";
import TransactionHistory from "./TransactionHistory";

const Transaction = () => {
  const [balance, setBalance] = useState(1000);
  const [amount, setAmount] = useState("");
  const [transactions, setTransactions] = useState([
  {
    id: 1,
    type: "Opening Balance",
    amount: 1000,
    balance: 1000,
  },
]);
 const deposit = () => {
  const value = Number(amount);

  if (value <= 0) {
    alert("Enter valid amount");
    return;
  }

  const newBalance = balance + value;

  setBalance(newBalance);

  setTransactions([
    ...transactions,
    {
      id: transactions.length + 1,
      type: "Deposit",
      amount: value,
      balance: newBalance,
    },
  ]);

  setAmount("");
};
  const withdraw = () => {
  const value = Number(amount);

  if (value <= 0) {
    alert("Enter valid amount");
    return;
  }

  if (value > balance) {
    alert("Insufficient Balance");
    return;
  }

  const newBalance = balance - value;

  setBalance(newBalance);

  setTransactions([
    ...transactions,
    {
      id: transactions.length + 1,
      type: "Withdraw",
      amount: value,
      balance: newBalance,
    },
  ]);

  setAmount("");
};

  return (
    <div className="transaction">
      <h2>Transaction</h2>

      <div className="balance-card">
        <h3>Available Balance</h3>
        <h1>₹{balance}</h1>
      </div>

      <div className="input-group">
        <label>Enter Amount</label>

        <input
          type="number"
          placeholder="Enter amount"
          value={amount}
          onChange={(e) => setAmount(e.target.value)}
        />
      </div>

      <div className="button-group">
        <button className="deposit-btn" onClick={deposit}>
          Deposit
        </button>

        <button className="withdraw-btn" onClick={withdraw}>
          Withdraw
        </button>
       
      </div>
       <TransactionHistory transactions={transactions} />
    </div>
  );
};

export default Transaction;