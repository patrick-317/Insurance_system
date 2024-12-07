import React, { useState, useEffect } from 'react';
import { login } from '../services/api';
import '../styles/login.css'; // 스타일링 파일이 있다면 import 해주세요.
import { useNavigate } from 'react-router-dom'; // 페이지 이동을 위해 추가

const Login = () => {
  const [credentials, setCredentials] = useState({
    email: '',
    password: '',
  });
  const [loading, setLoading] = useState(false);
  const [isLoggedIn, setIsLoggedIn] = useState(false);
  const navigate = useNavigate(); // 페이지 이동용 훅

  useEffect(() => {
    const customerId = localStorage.getItem('customerId');
    if (customerId) {
      setIsLoggedIn(true);
    }
  }, []);

  const handleChange = (e) => {
    const { name, value } = e.target;
    setCredentials({
      ...credentials,
      [name]: value,
    });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    setLoading(true);
    try {
      const result = await login(credentials.email, credentials.password);
      if (result) {
        alert('Login successful!');
        console.log(result);
        localStorage.setItem('customerId', result.id);
        window.location.href = '/';
      } else {
        alert('Login failed! Please try again.');
      }
    } catch (error) {
      console.error('Login error:', error);
      alert('An error occurred during login. Please try again.');
    } finally {
      setLoading(false);
    }
  };

  const handleLogout = () => {
    localStorage.removeItem('customerId');
    alert('Logged out successfully!');
    setIsLoggedIn(false);
    window.location.href = '/login';
  };

  const handleSignupRedirect = () => {
    navigate('/inquiry'); // 회원가입 페이지로 이동
  };

  return (
    <div className="login-page">
      <h1>{isLoggedIn ? 'Welcome Back!' : 'Login'}</h1>
      {isLoggedIn ? (
        <button onClick={handleLogout} className="logout-button">
          Logout
        </button>
      ) : (
        loading ? (
          <p>Loading...</p>
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
            <button
              type="button"
              onClick={handleSignupRedirect}
              className="login-button"
            >
              회원가입 및 보험가입
            </button>
          </form>
        )
      )}
    </div>
  );
};

export default Login;