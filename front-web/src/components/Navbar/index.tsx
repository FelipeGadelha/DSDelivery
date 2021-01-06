import React from 'react';
import {ReactComponent as Logo } from '../../assets/logo.svg';

import './styles.css';

const Navbar: React.FC = () => {
  return (
    <nav className="main-navbar">
        <a href="home" className="content-logo">
            <Logo className="logo"/>
            DS Delivery
        </a>
        
    </nav>
  );
}

export default Navbar;