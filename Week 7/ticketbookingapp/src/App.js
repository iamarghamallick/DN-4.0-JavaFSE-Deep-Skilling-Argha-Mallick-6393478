import React, { Component } from 'react';
import './App.css';

function UserGreeting(props) {
  return <h1>Welcome back</h1>;
}

function GuestGreeting(props) {
  return (
    <div>
      <h1>Please sign up.</h1>
      <div className="flight-details">
        <h3>Available Flights</h3>
        <p>Flight 6E 202: Kolkata to Chennai</p>
        <p>Flight AI 809: Delhi to Mumbai</p>
      </div>
    </div>
  );
}

function Greeting(props) {
  const isLoggedIn = props.isLoggedIn;
  if (isLoggedIn) {
    return <UserGreeting />;
  }
  return <GuestGreeting />;
}

function LoginButton(props) {
  return <button onClick={props.onClick}>Login</button>;
}

function LogoutButton(props) {
  return <button onClick={props.onClick}>Logout</button>;
}

class App extends Component {
  constructor(props) {
    super(props);
    this.handleLoginClick = this.handleLoginClick.bind(this);
    this.handleLogoutClick = this.handleLogoutClick.bind(this);
    this.state = { isLoggedIn: false };
  }

  handleLoginClick() {
    this.setState({ isLoggedIn: true });
  }

  handleLogoutClick() {
    this.setState({ isLoggedIn: false });
  }

  render() {
    const isLoggedIn = this.state.isLoggedIn;
    let button;

    if (isLoggedIn) {
      button = <LogoutButton onClick={this.handleLogoutClick} />;
    } else {
      button = <LoginButton onClick={this.handleLoginClick} />;
    }

    return (
      <div className="container">
        <Greeting isLoggedIn={isLoggedIn} />
        {button}
        {isLoggedIn && (
          <div className="booking-section">
            <h3>Ready to travel?</h3>
            <button className="book-now">Book a Ticket</button>
          </div>
        )}
      </div>
    );
  }
}

export default App;