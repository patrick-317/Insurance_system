import React from 'react';
import { Link } from 'react-router-dom';
import '../styles/Navbar.css';

const Navbar = () => {
  return (
    <nav className="navbar">
      <div className="navbar-logo">보험 관리 시스템</div>
      <ul className="navbar-menu">
        <li>
          <Link to="/manage-subscriptions">보험 가입 관리</Link>
        </li>
        <li>
          <Link to="/create-insurance">보험 개발</Link>
        </li>
        <li>
          <Link to="/manage-payouts">보험금 지급 관리</Link>
        </li>
      </ul>
    </nav>
  );
};

export default Navbar;