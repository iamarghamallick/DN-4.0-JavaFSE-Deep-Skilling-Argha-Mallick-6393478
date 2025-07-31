import React, { Component } from 'react';

const validEmailRegex = RegExp(
  /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/
);

const validateForm = errors => {
  let valid = true;
  Object.values(errors).forEach(val => val.length > 0 && (valid = false));
  return valid;
};

export default class Register extends Component {
  constructor(props) {
    super(props);
    this.state = {
      fullName: '',
      email: '',
      password: '',
      errors: {
        fullName: '',
        email: '',
        password: '',
      }
    };
  }

  handleChange = (event) => {
    event.preventDefault();
    const { name, value } = event.target;
    let errors = this.state.errors;

    switch (name) {
      case 'fullName':
        errors.fullName =
          value.length < 5
            ? 'Full Name must be 5 characters long!'
            : '';
        break;
      case 'email':
        errors.email =
          validEmailRegex.test(value)
            ? ''
            : 'Email is not valid!';
        break;
      case 'password':
        errors.password =
          value.length < 8
            ? 'Password must be 8 characters long!'
            : '';
        break;
      default:
        break;
    }

    this.setState({errors, [name]: value});
  }

  handleSubmit = (event) => {
    event.preventDefault();
    if(validateForm(this.state.errors)) {
      alert('Valid Form')
    } else {
       if (this.state.errors.fullName) {
         alert(this.state.errors.fullName);
       }
       if (this.state.errors.email) {
         alert(this.state.errors.email);
       }
       if (this.state.errors.password) {
         alert(this.state.errors.password);
       }
    }
  }

  render() {
    const {errors} = this.state;
    return (
      <div className='wrapper'>
        <div className='form-wrapper'>
          <h2 style={{color: "red", textAlign: "center"}}>Register Here!!!</h2>
          <form onSubmit={this.handleSubmit} noValidate>
            <div className='fullName'>
              <label htmlFor="fullName">Name:</label>
              <input type='text' name='fullName' onChange={this.handleChange} noValidate />
            </div>
            <div className='email'>
              <label htmlFor="email">Email:</label>
              <input type='email' name='email' onChange={this.handleChange} noValidate />
            </div>
            <div className='password'>
              <label htmlFor="password">Password:</label>
              <input type='password' name='password' onChange={this.handleChange} noValidate />
            </div>
            <div className='submit'>
              <button>Submit</button>
            </div>
          </form>
        </div>
      </div>
    );
  }
}