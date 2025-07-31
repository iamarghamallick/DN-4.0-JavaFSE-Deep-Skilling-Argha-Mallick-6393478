import React, { Component } from 'react';

class Welcome extends Component {
    sayWelcome(message) {
        alert(message);
    }

    render() {
        return (
            <div>
                <button onClick={() => this.sayWelcome('Welcome')}>Say Welcome</button>
            </div>
        );
    }
}

export default Welcome;