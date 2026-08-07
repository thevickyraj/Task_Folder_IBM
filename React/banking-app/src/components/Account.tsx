import "./Account.css";

const Account = () => {
  return (
    <div className="account">
      <h2>Account Details</h2>

      <div className="account-info">
        <div className="info-row">
          <span className="label">Account Number</span>
          <span>1234567890</span>
        </div>

        <div className="info-row">
          <span className="label">Account Holder</span>
          <span>Vicky</span>
        </div>

        <div className="info-row">
          <span className="label">Account Type</span>
          <span>Savings</span>
        </div>

        <div className="info-row">
          <span className="label">Branch</span>
          <span>Bangalore Main Branch</span>
        </div>

        <div className="info-row">
          <span className="label">IFSC Code</span>
          <span>SBIN0001234</span>
        </div>

        <div className="info-row">
          <span className="label">Mobile Number</span>
          <span>+91 9110615868</span>
        </div>

        <div className="info-row">
          <span className="label">Email</span>
          <span>vickyraj@gmail.com</span>
        </div>

        <div className="info-row">
          <span className="label">Account Status</span>
          <span className="status active">Active</span>
        </div>
      </div>
    </div>
  );
};

export default Account;