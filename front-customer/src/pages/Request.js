import React, { useState, useEffect } from 'react';
import '../styles/request.css';
import { requestPayout } from '../services/api';

const Request = () => {
  const [customerId, setCustomerId] = useState('');
  const [insuranceId, setInsuranceId] = useState('');
  const [responseMessage, setResponseMessage] = useState('');

  useEffect(() => {
    const storedCustomerId = localStorage.getItem('customerId');
    if (storedCustomerId) {
      setCustomerId(storedCustomerId); // 세션에서 customerId 읽기
    }
  }, []);

  const handleSubmit = async (e) => {
    e.preventDefault();

    try {
      const data = await requestPayout(customerId, insuranceId);

      if (data) {
        setResponseMessage(
          `요청 성공 : Status - ${data.status}, Amount - ${data.amount}`
        );
      } else {
        setResponseMessage('Error: No response data from the server.');
      }
    } catch (error) {
      console.error('Request failed:', error);
      setResponseMessage(`요청 실패: ${error.message || '고객 아이디와 보험 아이디를 확인 해주세요'}`);
    }
  };

  return (
    <div className="request-container">
      <h1>보험금 지급 요청</h1>
      <form onSubmit={handleSubmit} className="request-form">
        <label>
          Customer ID:
          <input
            type="text"
            value={customerId}
            readOnly // 수정 불가
          />
        </label>
        <label>
          Insurance ID:
          <input
            type="text"
            value={insuranceId}
            onChange={(e) => setInsuranceId(e.target.value)}
            placeholder="Enter Insurance ID"
            required
          />
        </label>
        <button type="submit">지급 요청</button>
      </form>
      {responseMessage && <p className="response-message">{responseMessage}</p>}
    </div>
  );
};

export default Request;