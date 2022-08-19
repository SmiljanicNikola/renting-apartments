import './App.css';
import {BrowserRouter as Router, Routes, Route} from 'react-router-dom'
import { Apartments } from './components/pages/Apartments';
import { Navbar } from './components/layout/Navbar';
import './assets/css/navbar.css'
import { Advertisements } from './components/pages/Advertisements';
import { Register } from './components/forms/Register';
import { Footer } from './components/layout/Footer';

function App() {
  return (
    <div className="App">
      
      <Router>
      <Navbar />

        <Routes>
          <Route exact path='/apartments' element={<Apartments/>}/>
          <Route exact path='/advertisements' element={<Advertisements/>}/>
          <Route exact path='/register' element={<Register/>}/>

        </Routes>

        <Footer />
      </Router>
    </div>
  );
}

export default App;
