import "./App.css";
import Dashboard from "./components/Dashboard";
import Account from "./components/Account";
import Transaction from "./components/Transaction";

function App() {
  return (
    <div className="app">
      <h1 className="app-title">🏦 Vicky Banking Application</h1>

      <Dashboard />
      <Account />
      <Transaction />
    </div>
  );
}

export default App;