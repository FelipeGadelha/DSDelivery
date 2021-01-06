import React from 'react';
import { Link } from 'react-router-dom';
import {ReactComponent as Logo } from '../../assets/logo.svg';

import './styles.css';

const Navbar: React.FC = () => {
  return (
    <nav className="main-navbar">
        <Link to="/" className="content-logo">
            <Logo className="logo"/>
            DS Delivery
        </Link>
        
    </nav>
  );
}

export default Navbar;