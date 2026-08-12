export default class BalanceController {
  constructor(dispatch) {
    this.dispatch = dispatch;
  }

  deposit(amount) {
    this.dispatch({ type: "DEPOSIT", payload: amount });
  }

  withdraw(amount) {
    this.dispatch({ type: "WITHDRAW", payload: amount });
  }
}
