import React, { Component } from 'react';

class Counter extends Component {
    constructor(props) {
        super(props);
        this.state = {
            count: 0,
        };
        this.handleIncrement = this.handleIncrement.bind(this);
        this.decrement = this.decrement.bind(this);
    }

    increment() {
        this.setState((prevState) => ({
            count: prevState.count + 1,
        }));
    }

    sayHello() {
        alert('Hello! The counter was increased.');
    }

    handleIncrement() {
        this.increment();
        this.sayHello();
    }

    decrement() {
        this.setState((prevState) => ({
            count: prevState.count - 1,
        }));
    }

    render() {
        return (
            <div>
                <h2>Counter Value: {this.state.count}</h2>
                <button onClick={this.handleIncrement}>Increment</button>
                <button onClick={this.decrement}>Decrement</button>
            </div>
        );
    }
}

export default Counter;