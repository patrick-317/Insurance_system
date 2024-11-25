import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Navbar from './components/Navbar';
import ManageSubscriptions from './pages/ManageSubscriptions';
import CreateInsurance from './pages/CreateInsurance';
import ManagePayouts from './pages/ManagePayouts';

const App = () => {
  return (
    <Router>
      <div>
        {/* 네비게이션 바 */}
        <Navbar />

        {/* 네비게이션 바 아래 콘텐츠 */}
        <div style={{ marginTop: '60px', padding: '20px' }}>
          <Routes>
            <Route path="/manage-subscriptions" element={<ManageSubscriptions />} />
            <Route path="/create-insurance" element={<CreateInsurance />} />
            <Route path="/manage-payouts" element={<ManagePayouts />} />
          </Routes>
        </div>
      </div>
    </Router>
  );
};

export default App;