import React from 'react';
import Counter from './Counter';
import Welcome from './Welcome';
import SyntheticEventDemo from './SyntheticEventDemo';
import CurrencyConverter from './CurrencyConverter';
import './App.css';

function App() {
  return (
    <div className="container">
      <h1>Task 1: Counter</h1>
      <p>Increases/decreases a value. The "Increment" button calls multiple functions.</p>
      <Counter />
      <hr />

      <h1>Task 2: Passing an Argument</h1>
      <p>Passes the string "Welcome" as an argument to the event handler.</p>
      <Welcome />
      <hr />

      <h1>Task 3: Synthetic Event</h1>
      <p>Uses the synthetic event to display a message.</p>
      <SyntheticEventDemo />
      <hr />

      <h1>Task 4: Currency Converter</h1>
      <p>Handles form events to convert INR to EUR.</p>
      <CurrencyConverter />
    </div>
  );
}

export default App;