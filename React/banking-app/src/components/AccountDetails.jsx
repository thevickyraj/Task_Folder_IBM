import React, { useEffect, useState } from "react";
import { fetchAccount } from "../api";

export default function AccountDetails() {
  const [account, setAccount] = useState(null);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  useEffect(() => {
    fetchAccount()
      .then((data) => setAccount(data))
      .catch((err) => {
        console.error("Account fetch error:", err);
        setError("Unable to load account data");
      })
      .finally(() => setLoading(false));
  }, []);

  if (loading) return <p>Loading account details...</p>;
  if (error) return <p style={{ color: "red" }}>{error}</p>;
  if (!account) return <p>No account data</p>;

  return (
    <div>
      <h2>Account Details (from API)</h2>
      <ul>
        <li>Account Number: {account.accountNumber}</li>
        <li>Holder: {account.accountHolder}</li>
        <li>Type: {account.accountType}</li>
        <li>Branch: {account.branch}</li>
        <li>IFSC: {account.ifsc}</li>
        <li>Mobile: {account.mobile}</li>
        <li>Email: {account.email}</li>
        <li>Status: {account.status}</li>
      </ul>
    </div>
  );
}
