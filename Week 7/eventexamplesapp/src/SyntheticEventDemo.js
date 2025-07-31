import React, { Component } from 'react';

class SyntheticEventDemo extends Component {
    handlePress(event) {
        console.log(event);
        alert('I was clicked');
    }

    render() {
        return (
            <div>
                <button onClick={this.handlePress}>OnPress</button>
            </div>
        );
    }
}

export default SyntheticEventDemo;