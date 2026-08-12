import "./App.css";
import { BrowserRouter, Routes, Route, Link } from "react-router-dom";
import Home from "./pages/Home.jsx";
import Accounts from "./pages/Accounts.jsx";
import About from "./pages/About.jsx";
import { useSelector } from "react-redux";
import BalanceControls from "./components/BalanceControls.jsx";

function App() {
  return (
    <BrowserRouter>
      <div className="app">
        <h1 className="app-title">🏦 Vicky Banking Application</h1>
        <nav style={{ marginBottom: 16 }}>
          <Link to="/">Home</Link> | <Link to="/accounts">Accounts</Link> |
          <Link to="/about"> About</Link>
        </nav>

        <main>
          <Routes>
            <Route path="/" element={<Home />} />
            <Route path="/accounts" element={<Accounts />} />
            <Route path="/about" element={<About />} />
          </Routes>

          <section style={{ marginTop: 24 }}>
            <h3>Redux Balance</h3>
            <p>
              Current balance: <strong>{useSelector((s: any) => s.balance)}</strong>
            </p>
            <BalanceControls />
          </section>
        </main>
      </div>
    </BrowserRouter>
  );
}

export default App;