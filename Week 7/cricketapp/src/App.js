import React from 'react';
import ListOfPlayers from './ListOfPlayers';
import ScoreBelow70 from './ScoreBelow70';
import IndianPlayers from './IndianPlayers';
import './App.css';

function App() {
  const flag = true;
  const players = [
    { name: 'Jack', score: 50 },
    { name: 'Michael', score: 70 },
    { name: 'John', score: 40 },
    { name: 'Ann', score: 61 },
    { name: 'Elisabeth', score: 61 },
    { name: 'Sachin', score: 95 },
    { name: 'Dhoni', score: 100 },
    { name: 'Virat', score: 84 },
    { name: 'Jadeja', score: 64 },
    { name: 'Raina', score: 75 },
    { name: 'Rohit', score: 80 },
  ];

  if (flag) {
    return (
      <div className="container">
        <h1>List of Players</h1>
        <ListOfPlayers players={players} />
        <hr />
        <h1>List of Players having Scores Less than 70</h1>
        <ScoreBelow70 players={players} />
      </div>
    );
  } else {
    return (
      <div className="container">
        <IndianPlayers />
      </div>
    );
  }
}

export default App;