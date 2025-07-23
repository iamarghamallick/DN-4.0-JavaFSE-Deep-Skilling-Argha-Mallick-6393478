import '../stylesheets/mystyle.css';

const percentToDecimal = (decimal) => {
    return (decimal.toFixed(2) + '%');
}

const calcScore = (total, goal) => {
    return percentToDecimal((total / goal));
}

const CalculateScore = ({ name, school, total, goal }) => {
    return (
        <div className="formatstyle">
            <h1><font color="brown">Student Details:</font></h1>
            <div className="name">
                <b><span>Name:</span></b>
                <span>{name}</span>
            </div>
            <div className="school">
                <b><span>School:</span></b>
                <span>{school}</span>
            </div>
            <div className="total">
                <b><span>Total Marks:</span></b>
                <span>{total}</span>
            </div>
            <div className="score">
                <b><span>Score:</span></b>
                <span>
                    {calcScore(total, goal)}
                </span>
            </div>
        </div>
    );
}

export default CalculateScore;