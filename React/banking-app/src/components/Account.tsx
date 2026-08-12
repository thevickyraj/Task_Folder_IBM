import { useEffect, useState } from "react";
import "./Account.css";

type AccountData = {
  accountNumber: string;
  accountHolder: string;
  accountType: string;
  branch: string;
  ifsc: string;
  mobile: string;
  email: string;
  status: string;
};

const defaultAccount: AccountData = {
  accountNumber: "1234567890",
  accountHolder: "Vicky",
  accountType: "Savings",
  branch: "Bangalore Main Branch",
  ifsc: "SBIN0001234",
  mobile: "+91 9110615868",
  email: "vickyraj@gmail.com",
  status: "Active",
};

const Account = () => {
  const [account, setAccount] = useState<AccountData>(defaultAccount);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState<string | null>(null);

  useEffect(() => {
    const apiUrl = "https://api.examplebank.com/accounts/12345";

    const loadAccount = async () => {
      const response = await fetch(apiUrl);
      if (!response.ok) {
        throw new Error(`Network response was not ok (${response.status})`);
      }
      return response.json();
    };

    loadAccount()
      .then((data) => {
        setAccount({
          accountNumber: data.accountNumber ?? defaultAccount.accountNumber,
          accountHolder: data.accountHolder ?? defaultAccount.accountHolder,
          accountType: data.accountType ?? defaultAccount.accountType,
          branch: data.branch ?? defaultAccount.branch,
          ifsc: data.ifsc ?? defaultAccount.ifsc,
          mobile: data.mobile ?? defaultAccount.mobile,
          email: data.email ?? defaultAccount.email,
          status: data.status ?? defaultAccount.status,
        });
      })
      .catch((fetchError) => {
        console.error("Failed to load account details:", fetchError);
        setError("Unable to load account details. Showing saved data.");
      })
      .finally(() => {
        setLoading(false);
      });
  }, []);

  return (
    <div className="account">
      <h2>Account Details</h2>
      {loading && <p className="status-message">Loading account details...</p>}
      {error && <p className="status-message error">{error}</p>}

      <div className="account-info">
        <div className="info-row">
          <span className="label">Account Number</span>
          <span>{account.accountNumber}</span>
        </div>

        <div className="info-row">
          <span className="label">Account Holder</span>
          <span>{account.accountHolder}</span>
        </div>

        <div className="info-row">
          <span className="label">Account Type</span>
          <span>{account.accountType}</span>
        </div>

        <div className="info-row">
          <span className="label">Branch</span>
          <span>{account.branch}</span>
        </div>

        <div className="info-row">
          <span className="label">IFSC Code</span>
          <span>{account.ifsc}</span>
        </div>

        <div className="info-row">
          <span className="label">Mobile Number</span>
          <span>{account.mobile}</span>
        </div>

        <div className="info-row">
          <span className="label">Email</span>
          <span>{account.email}</span>
        </div>

        <div className="info-row">
          <span className="label">Account Status</span>
          <span className={`status ${account.status.toLowerCase()}`}>
            {account.status}
          </span>
        </div>
      </div>
    </div>
  );
};

export default Account;