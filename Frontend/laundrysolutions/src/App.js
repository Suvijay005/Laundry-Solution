import logo from './logo.svg';
import './App.css';
import {BrowserRouter as Router, Route, Switch} from "react-router-dom";
// import HomePage from './Components/HomePage/HomePage';
// import Home from './Components/Home';
import UserComponent from './Components/UserComponent';
function App() {
  return (
    <div className="App">
      Home
      <Router>
         <Switch>
          {/* <Route path="/" exact render={()=> <HomePage></HomePage>}></Route> */}

          {/* <Route path='/' exact render={()=><Home></Home>}></Route> */}


          <Route path='/' exact render={()=><UserComponent></UserComponent>}></Route>


         </Switch>






      </Router>





    </div>
  );
}

export default App;
