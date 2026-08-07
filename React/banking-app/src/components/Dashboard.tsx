import "./Dashboard.css";

const Dashboard = () => {
  return (
    <div className="dashboard">
      <h2>Customer Details</h2>

      <div className="customer-grid">
        <span>Name</span>
        <span>Vicky</span>

        <span>Account Number</span>
        <span>1234567890</span>

        <span>Account Type</span>
        <span>Savings</span>

        <span>Balance</span>
        <span>₹50,00,000</span>
      </div>
    </div>
  );
};

export default Dashboard;