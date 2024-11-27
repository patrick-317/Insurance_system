import React, { useState } from 'react';
import { login } from '../services/api';
import '../styles/login.css'; // 스타일링 파일이 있다면 import 해주세요.

const Login = () => {
  const [credentials, setCredentials] = useState({
    email: '',
    password: '',
  });

  const [isLoggedIn, setIsLoggedIn] = useState(false); // 로그인 상태 관리

  const handleChange = (e) => {
    const { name, value } = e.target;
    setCredentials({
      ...credentials,
      [name]: value,
    });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    const result = await login(credentials.email, credentials.password); // 수정된 필드 이름
    if (result) {
      alert('Login successful!');
      setIsLoggedIn(true); // 로그인 상태로 변경
    } else {
      alert('Login failed! Please try again.');
    }
  };

  const handleLogout = () => {
    setIsLoggedIn(false); // 로그아웃 시 로그인 상태를 false로 변경
    setCredentials({ email: '', password: '' }); // 입력 필드 초기화
    alert('Logged out successfully!');
  };

  return (
    <div className="login-page">
      <h1>{isLoggedIn ? 'Welcome!' : 'Login'}</h1>
      {isLoggedIn ? (
        <div>
          <p>You are logged in as {credentials.email}</p>
          <button onClick={handleLogout} className="logout-button">
            Logout
          </button>
        </div>
      ) : (
        <form onSubmit={handleSubmit} className="login-form">
          <label>
            Email:
            <input
              type="text"
              name="email"
              value={credentials.email}
              onChange={handleChange}
              required
            />
          </label>
          <label>
            Password:
            <input
              type="password"
              name="password"
              value={credentials.password}
              onChange={handleChange}
              required
            />
          </label>
          <button type="submit" className="login-button">Login</button>
        </form>
      )}
    </div>
  );
};

export default Login;