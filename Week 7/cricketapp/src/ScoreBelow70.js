import React from 'react';

function ScoreBelow70({ players }) {
  const playersBelow70 = players.filter(player => player.score <= 70);

  return (
    <ul>
      {playersBelow70.map((player) => (
        <li key={player.name}>
          Mr. {player.name} {player.score}
        </li>
      ))}
    </ul>
  );
}

export default ScoreBelow70;