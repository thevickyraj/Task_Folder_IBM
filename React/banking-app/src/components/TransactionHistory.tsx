import "./TransactionHistory.css";
type Transaction = {
  id: number;
  type: string;
  amount: number;
  balance: number;
};

type Props = {
  transactions: Transaction[];
};

const TransactionHistory = ({ transactions }: Props) => {
  return (
    <div className="history">
      <h2>Transaction History</h2>

      <table>
        <thead>
          <tr>
            <th>ID</th>
            <th>Type</th>
            <th>Amount</th>
            <th>Balance</th>
          </tr>
        </thead>

        <tbody>
  {transactions.map((transaction) => (
    <tr key={transaction.id}>
      <td>{transaction.id}</td>

      <td
        className={
          transaction.type === "Deposit"
            ? "deposit"
            : transaction.type === "Withdraw"
            ? "withdraw"
            : "opening"
        }
      >
        {transaction.type}
      </td>

      <td>₹{transaction.amount}</td>
      <td>₹{transaction.balance}</td>
    </tr>
  ))}
</tbody>
      </table>
    </div>
  );
};

export default TransactionHistory;