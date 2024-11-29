
// src/components/Sidebar.js
import React, { useState } from 'react';
import '../styles/sidebar.css';

const Sidebar = () => {
  const [isOpen, setIsOpen] = useState(false);

  const toggleSidebar = () => {
    setIsOpen(!isOpen);
  };

  return (
    <div>
      <button className="sidebar-toggle" onClick={toggleSidebar}>
        {isOpen ? 'Close' : 'Menu'}
      </button>
      <aside className={`sidebar ${isOpen ? 'open' : ''}`}>
        <ul>
          <li><a href="/">Main page</a></li>
          {/* <li><a href="/login">Login</a></li> */}
          {/* <li><a href="/customers">Customer Management</a></li>
          <li><a href="/products">Product Catalog</a></li>
          <li><a href="/contracts">Contract Management</a></li> */}
          {/* <li><a href="/claims">Claim Processing</a></li> */}
          <li><a href="/inquiry">보험 조회 및 가입</a></li>
          <li><a href="/request">보험금 지급 요청</a></li>
          <li><a href="/requestInvestment">사고 조사 요청</a></li>

        </ul>
      </aside>
    </div>
  );
};

export default Sidebar;