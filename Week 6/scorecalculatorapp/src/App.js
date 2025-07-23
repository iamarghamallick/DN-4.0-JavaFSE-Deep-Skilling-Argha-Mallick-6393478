import './App.css';
import CalculateScore from './components/CalculateScore';

function App() {
  return (
    <div>
      <CalculateScore
        name={"Argha"}
        school={"BPPIMT"}
        total={284}
        goal={3}
      />
    </div>
  );
}

export default App;
