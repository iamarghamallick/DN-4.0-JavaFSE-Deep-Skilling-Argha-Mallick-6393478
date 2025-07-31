import React from 'react';

const T20Players = ['First Player', 'Second Player', 'Third Player'];
const RanjiTrophyPlayers = ['Fourth Player', 'Fifth Player', 'Sixth Player'];
const IndianPlayersList = [...T20Players, ...RanjiTrophyPlayers];
const team = ['Sachin', 'Dhoni', 'Virat', 'Rohit', 'Yuvraj', 'Raina'];

function OddPlayers({ players }) {
    const [first, , third, , fifth] = players;
    return (
        <ul>
            <li>First : {first}</li>
            <li>Third : {third}</li>
            <li>Fifth : {fifth}</li>
        </ul>
    );
}

function EvenPlayers({ players }) {
    const [, second, , fourth, , sixth] = players;
    return (
        <ul>
            <li>Second : {second}</li>
            <li>Fourth : {fourth}</li>
            <li>Sixth : {sixth}</li>
        </ul>
    );
}

function IndianPlayers() {
    return (
        <div>
            <h2>Odd Players</h2>
            <OddPlayers players={team} />
            <hr />
            <h2>Even Players</h2>
            <EvenPlayers players={team} />
            <hr />
            <h2>List of Indian Players Merged:</h2>
            <ul>
                {IndianPlayersList.map((player) => (
                    <li key={player}>Mr. {player}</li>
                ))}
            </ul>
        </div>
    );
}

export default IndianPlayers;