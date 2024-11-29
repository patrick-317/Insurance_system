import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import Navbar from './components/Navbar';
import Sidebar from './components/Sidebar';
import Footer from './components/Footer';
import Home from './pages/Home';
import Login from './pages/Login';
import Request from './pages/Request';
import RequestInvestment from './pages/RequestInvestment';
import ProductSubscription from './pages/ProductSubscription';
import Inquiry from './pages/InsuranceInquiry';


function App() {
  return (
    <Router>
      <div className="app">
        <Navbar />
        <Sidebar />
        <main>
          <Routes>
            <Route path="/" element={<Home />} />
            <Route path="/subscription" element={<ProductSubscription />} />
            <Route path="/login" element={<Login />} />
            <Route path="/inquiry" element={<Inquiry />} />
            <Route path="/request" element={<Request />} />
            <Route path="/requestInvestment" element={<RequestInvestment />} />
          </Routes>
        </main>
        <Footer />
      </div>
    </Router>
  );
}

export default App;