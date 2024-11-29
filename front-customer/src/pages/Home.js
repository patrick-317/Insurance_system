// src/pages/Home.js
import React from 'react';
import { Link } from 'react-router-dom';
import '../styles/home.css'; // 스타일링 파일

const Home = () => {
  return (
    <div className="home">
      <h1>Welcome</h1>
      <div className="dashboard">
        {/* <div className="card">
          <h2>보험 가입</h2>
          <Link to="/subscription" className="card-button">
            바로 가기
          </Link>
        </div> */}
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