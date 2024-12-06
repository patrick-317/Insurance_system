import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Login from './pages/Login';
import Home from './pages/Home';
import Request from './pages/Request';
import InsuranceInquiry from './pages/InsuranceInquiry';
import ProductSubscription from './pages/ProductSubscription';
import RequestInvestment from './pages/RequestInvestment';
import ProtectedRoute from './components/ProtectedRoute';
import Layout from './components/Layout';

const App = () => {
  return (
    <Router>
      <Routes>
        {/* 로그인 페이지 */}
        <Route path="/login" element={<Login />} />

        {/* 로그인 여부에 따라 접근 가능한 페이지 */}
        <Route
          path="/"
          element={
            <ProtectedRoute>
              <Layout>
                <Home />
              </Layout>
            </ProtectedRoute>
          }
        />
        <Route
          path="/request"
          element={
            <ProtectedRoute>
              <Layout>
                <Request />
              </Layout>
            </ProtectedRoute>
          }
        />
        <Route
          path="/inquiry"
          element={
            <ProtectedRoute>
              <Layout>
                <InsuranceInquiry />
              </Layout>
            </ProtectedRoute>
          }
        />
        <Route
          path="/subscription"
          element={
            <ProtectedRoute>
              <Layout>
                <ProductSubscription />
              </Layout>
            </ProtectedRoute>
          }
        />
        <Route
          path="/requestInvestment"
          element={
            <ProtectedRoute>
              <Layout>
                <RequestInvestment />
              </Layout>
            </ProtectedRoute>
          }
        />
      </Routes>
    </Router>
  );
};

export default App;