import React, { Component } from 'react';

class CurrencyConverter extends Component {
    constructor(props) {
        super(props);
        this.state = {
            rupees: 0,
            euros: 0,
        };
        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    handleChange(event) {
        this.setState({ rupees: event.target.value });
    }

    handleSubmit(event) {
        event.preventDefault();
        const conversionRate = 90.0;
        const convertedEuros = (this.state.rupees / conversionRate).toFixed(2);
        this.setState({ euros: convertedEuros });
    }

    render() {
        return (
            <form onSubmit={this.handleSubmit}>
                <div>
                    <label>Indian Rupees (INR): </label>
                    <input
                        type="number"
                        value={this.state.rupees}
                        onChange={this.handleChange}
                    />
                </div>
                <button type="submit">Convert</button>
                <h3>Euros (EUR): {this.state.euros}</h3>
            </form>
        );
    }
}

export default CurrencyConverter;