import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import './App.css';
import Login from './Components/Login';
import Signup from './Components/SignUp';
import { Link } from 'react-router-dom';
function App() {
  return (
    <Router>
       <nav>
      <ul>
        <li>
          <Link to="/login">User Login</Link>
        </li>
        <li>
          <Link to="/signup">User Signup</Link>
        </li>
      </ul>
    </nav>
      <div className="App">
      
      
        <Routes>
          <Route path="/login" element={<Login />} />
          <Route path="/signup" element={<Signup />} />
        </Routes>
      </div>
    </Router>
  );
}

export default App;
