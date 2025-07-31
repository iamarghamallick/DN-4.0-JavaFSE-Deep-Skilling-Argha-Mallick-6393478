import React from 'react';
import './App.css';

function App() {
  const imageUrl = 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQxrJtMF5SH36A9c7cVSADdruAug_tE5KpWcg&s';
  const officeSpaces = [
    { name: 'DBS', rent: 50000, address: 'Chennai' },
    { name: 'DBS1', rent: 75000, address: 'Kolkata' },
    { name: 'DBS2', rent: 45000, address: 'Mumbai' }
  ];

  return (
    <div className="container">
      <h1>Office Space, at Affordable Range</h1>
      {officeSpaces.map((office, index) => {
        const rentStyle = {
          color: office.rent <= 60000 ? 'red' : 'green'
        };

        return (
          <div key={index} className="office-card">
            <img src={imageUrl} alt="Office Space" className="office-image" />
            <div className="office-details">
              <h2>Name: {office.name}</h2>
              <h3>Rent: Rs. <span style={rentStyle}>{office.rent}</span></h3>
              <h3>Address: {office.address}</h3>
            </div>
          </div>
        );
      })}
    </div>
  );
}

export default App;