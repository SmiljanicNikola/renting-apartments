import './App.css';
import {BrowserRouter as Router, Routes, Route} from 'react-router-dom'
import { Apartments } from './components/pages/Apartments/Apartments';
import { Navbar } from './components/layout/Navbar';
import './assets/css/navbar.css'
import { Advertisements } from './components/pages/Advertisements/Advertisements';
import { Register } from './components/forms/Register';
import { Footer } from './components/layout/Footer';
import { RentRequestForm } from './components/forms/RentRequestForm';
import { Advertisementss } from './components/pages/Advertisements/Advertisementss';
import { AddAdvertisement } from './components/pages/AddAdvertisement/AddAdvertisement';

function App() {
  return (
    <div className="App">
      
      <Router>
      <Navbar />

        <Routes>
          <Route exact path='/apartments' element={<Apartments/>}/>
          <Route exact path='/advertisements' element={<Advertisementss/>}/>
          <Route exact path='/register' element={<Register/>}/>
          <Route exact path='/rentRequest' element={<RentRequestForm/>}/>
          <Route exact path='/addAdvertisement' element={<AddAdvertisement/>}/>

        </Routes>

        <Footer />
      </Router>
    </div>
  );
}

export default App;
