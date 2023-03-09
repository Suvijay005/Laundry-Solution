import logo from './logo.svg';
import './App.css';
import {BrowserRouter as Router, Route, Switch} from "react-router-dom";
import HomePage from './Components/HomePage/HomePage';
function App() {
  return (
    <div className="App">
      <Router>
         <Switch>
          <Route path="/" exact render={()=> <HomePage></HomePage>}></Route>

         




         </Switch>






      </Router>





    </div>
  );
}

export default App;
