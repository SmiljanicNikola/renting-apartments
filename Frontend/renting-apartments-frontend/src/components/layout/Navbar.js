import React,{useState, useEffect} from 'react'
import { AuthenticationService } from '../../services/AuthenticationService';
import '../../assets/css/navbar.css'
import { Link } from 'react-router-dom';

export const Navbar = ({toggle}) => {

  const role = AuthenticationService.getRole();
  const username = AuthenticationService.getUsername();

  const handleLogout = () => {
    AuthenticationService.logout("/login'");
};

    const [active, setActive] = useState("nav__menu");
    const [icon, setIcon] = useState("nav__toggler");

  const navToggle = () => {
    if (active === "nav__menu") {
      setActive("nav__menu nav__active");
    } else setActive("nav__menu");

    // Icon Toggler
    if (icon === "nav__toggler") {
      setIcon("nav__toggler toggle");
    } else setIcon("nav__toggler");
    
  };

  return (
    <nav className="nav">
      <a href="#" className="nav__brand">
        RentApart
      </a>
      
      <ul className={active}>
        {/* {role( */}
          <li className="nav__item">
            <a href="/advertisements" className="nav__link">
              Home
            </a>
          </li>
        {/* )} */}

        {role == 'RENTER' && (
          <li className="nav__item">
            <a href="/apartments" className="nav__link">
              Apartment
            </a>
          </li>
        )}

        {role == 'CLIENT' && (
          <li className="nav__item">
            <a href="/advertisements" className="nav__link">
              Advertisements
            </a>
          </li>
        )}

        {!role && (
          <li className="nav__item">
            <a href="/register" className="nav__link">
              Register
            </a>
          </li>
        )}

        {!role && (   
          <li className="nav__item">
            <a href="/login" className="nav__link">
              Login
            </a>
          </li>
        )}

        {role && (   
          <li className="nav__item">
              <button onClick={handleLogout}>Logout</button>
          </li>
        )}
        
        

      </ul>
      <div onClick={navToggle} className={icon}>
        <div className="line1"></div>
        <div className="line2"></div>
        <div className="line3"></div>
      </div>







{/* 
      <Link to="/">🏠 Home</Link>

{role === 'CLIENT' && (
    <>
        <Link to="/apartments">View Apartments</Link>
        <Link to="/my-requests">My Rent Requests</Link>
    </>
)}

{role === 'RENTER' && (
    <>
        <Link to="/my-apartments">My Apartments</Link>
        <Link to="/add-apartment">Add Apartment</Link>
        <Link to="/rent-requests">Manage Rent Requests</Link>
    </>
)}

{!role && (
    <>
        <Link to="/login">Login</Link>
        <Link to="/register">Register</Link>
    </>
)}

{role && (
    <>
        <span>Welcome, {username}!</span>
        <button onClick={AuthenticationService.logout}>Logout</button>
    </>
)}
 */}


    </nav>
  );
}
