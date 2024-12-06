import React from 'react';
import { Link, useNavigate } from 'react-router-dom';
import '../styles/home.css';

const Home = () => {
  const navigate = useNavigate();

  const handleLogout = () => {
    localStorage.removeItem('customerId'); // customerId 삭제
    alert('Logged out successfully!');
    navigate('/login'); // 로그인 페이지로 이동
  };

  return (
    <div className="home">
      <div className="header">
        <h1>Welcome</h1>
        <button onClick={handleLogout} className="logout-button">
          Logout
        </button>
      </div>
      <div className="dashboard">
        <div className="card">
          <h2>보험 조회 및 가입</h2>
          <Link to="/inquiry" className="card-button">
            바로 가기
          </Link>
        </div>
        <div className="card">
          <h2>보험금 지급 요청</h2>
          <Link to="/request" className="card-button">
            바로 가기
          </Link>
        </div>
        <div className="card">
          <h2>사고 조사 요청</h2>
          <Link to="/requestInvestment" className="card-button">
            바로 가기
          </Link>
        </div>
      </div>
    </div>
  );
};

export default Home;