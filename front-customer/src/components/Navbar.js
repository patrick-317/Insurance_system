// src/components/Navbar.js
import React from 'react';
import '../styles/navbar.css';

const Navbar = () => {
  return (
    <nav className="navbar">
      <div className="navbar-logo">
        <h1>Insurance System</h1>
      </div>
      <ul className="navbar-menu">
        <li><a href="/">Home</a></li>
        {/* <li><a href="/login">Login</a></li> */}
        {/* <li><a href="/customers">Customers</a></li>
        <li><a href="/products">Products</a></li> */}
        {/* <li><a href="/claims">Claims</a></li> */}
        <li><a href="/inquiry">보험 조회 및 가입</a></li>
        <li><a href="/request">보험금 지급 요청</a></li>
      </ul>
    </nav>
  );
};

export default Navbar;