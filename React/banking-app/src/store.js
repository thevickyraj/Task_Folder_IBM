import { createStore } from "redux";

// Initial state
const initialState = {
  balance: 1000,
};

// Actions
export const deposit = (amount) => ({ type: "DEPOSIT", payload: amount });
export const withdraw = (amount) => ({ type: "WITHDRAW", payload: amount });

// Reducer
function reducer(state = initialState, action) {
  const amount = Number(action.payload);

  if (action.type === "DEPOSIT") {
    if (Number.isNaN(amount) || amount <= 0) {
      return state;
    }
    return { ...state, balance: state.balance + amount };
  }

  if (action.type === "WITHDRAW") {
    if (Number.isNaN(amount) || amount <= 0 || amount > state.balance) {
      return state;
    }
    return { ...state, balance: state.balance - amount };
  }

  return state;
}

const store = createStore(
  reducer,
  // enable Redux DevTools when available
  window.__REDUX_DEVTOOLS_EXTENSION__ && window.__REDUX_DEVTOOLS_EXTENSION__()
);

export default store;
