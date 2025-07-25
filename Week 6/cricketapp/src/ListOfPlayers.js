import React from 'react';

function ListOfPlayers({ players }) {
    return (
        <ul>
            {players.map((player) => (
                <li key={player.name}>
                    Mr. {player.name} {player.score}
                </li>
            ))}
        </ul>
    );
}

export default ListOfPlayers;