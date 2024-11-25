import React, { useState } from 'react';
import '../styles/request.css'

const Request = () => {
  const [customerId, setCustomerId] = useState('');
  const [insuranceId, setInsuranceId] = useState('');
  const [responseMessage, setResponseMessage] = useState('');

  const handleSubmit = async (e) => {
    e.preventDefault();

    // 요청 바디 데이터
    const requestBody = {
      customerId,
      insuranceId,
    };

    try {
      const response = await fetch('/api/insurance/request', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(requestBody),
      });

      if (response.ok) {
        const data = await response.json();
        setResponseMessage(`Request successful: ${data.message}`);
      } else {
        const errorData = await response.json();
        setResponseMessage(`Error: ${errorData.message}`);
      }
    } catch (error) {
      setResponseMessage('Failed to send request. Please try again later.');
    }
  };

  return (
    <div className="request-container">
      <h1>Insurance Payout Request</h1>
      <form onSubmit={handleSubmit} className="request-form">
        <label>
          Customer ID:
          <input
            type="text"
            value={customerId}
            onChange={(e) => setCustomerId(e.target.value)}
            placeholder="Enter Customer ID"
            required
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
        <button type="submit">Submit Request</button>
      </form>
      {responseMessage && <p className="response-message">{responseMessage}</p>}
    </div>
  );
};

export default Request;