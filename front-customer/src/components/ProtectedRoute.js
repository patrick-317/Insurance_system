import React from 'react';
import { Navigate } from 'react-router-dom';

const ProtectedRoute = ({ children }) => {
  const customerId = localStorage.getItem('customerId'); // 로그인 상태 확인

  if (!customerId) {
    // 로그인되지 않은 경우 로그인 페이지로 리다이렉트
    return <Navigate to="/login" replace />;
  }

  // 로그인된 경우 페이지 렌더링
  return children;
};

export default ProtectedRoute;