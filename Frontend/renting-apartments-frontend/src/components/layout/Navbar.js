import React,{useState, useEffect} from 'react'

import '../../assets/css/navbar.css'


export const Navbar = ({toggle}) => {

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
        <li className="nav__item">
          <a href="#" className="nav__link">
            Home
          </a>
        </li>
        <li className="nav__item">
          <a href="/apartments" className="nav__link">
            Apartment
          </a>
        </li>
        <li className="nav__item">
          <a href="/advertisements" className="nav__link">
            Advertisements
          </a>
        </li>
        <li className="nav__item">
          <a href="/register" className="nav__link">
            Register
          </a>
        </li>
        <li className="nav__item">
          <a href="/login" className="nav__link">
            Login
          </a>
        </li>
        
        
      </ul>
      <div onClick={navToggle} className={icon}>
        <div className="line1"></div>
        <div className="line2"></div>
        <div className="line3"></div>
      </div>
    </nav>
  );
}
