// src/pages/InsuranceInquiry.js
import React, { useState } from 'react';
import { fetchInsuranceDetails } from '../services/api';
import { useNavigate } from 'react-router-dom';
import '../styles/insuranceInquiry.css';

const InsuranceInquiry = () => {
  const [typeChoice, setTypeChoice] = useState('');
  const [insuranceData, setInsuranceData] = useState([]);
  const [error, setError] = useState('');
  const navigate = useNavigate();

  const handleChange = (e) => {
    setTypeChoice(e.target.value);
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    try {
      // 서버가 "type" 형식으로 요청받으므로 매핑
      const data = await fetchInsuranceDetails({ type: typeChoice });
      if (data && data.length > 0) {
        setInsuranceData(data); // 배열 데이터 설정
        setError('');
      } else {
        setError('보험이 존재하지 않습니다.');
        setInsuranceData([]);
      }
    } catch (err) {
      setError('서버와의 통신 에러 발생. 잠시 후 시도 해주세요.');
      setInsuranceData([]);
    }
  };

  const handleSelectInsurance = (id) => {
    navigate('/subscription', { state: { insuranceId: id } });
  };

  return (
    <div className="insurance-inquiry">
      <h1>보험 상품 조회</h1>
      <form onSubmit={handleSubmit} className="inquiry-form">
        <label>
          보험 타입 선택:
          <select
            name="typeChoice"
            value={typeChoice}
            onChange={handleChange}
            required
          >
            <option value="">선택</option>
            <option value="LIFE_INSURANCE">생명 보험</option>
            <option value="DAMAGE_INSURANCE">건강 보험</option>
            <option value="3">제 3보험</option>
          </select>
        </label>
        <button type="submit" className="inquiry-button">
          선택
        </button>
      </form>

      {error && <p className="error-message">{error}</p>}

      {insuranceData.length > 0 && (
        <div className="insurance-details">
          <h2>보험 상품 상세 정보</h2>
          {insuranceData.map((insurance) => (
            <div key={insurance.id} className="insurance-card">
              <p><strong>Name:</strong> {insurance.name}</p>
              <p><strong>Description:</strong> {insurance.description}</p>
              <p><strong>Premium:</strong> {insurance.premium}</p>
              <p><strong>Coverage:</strong> {insurance.coverage}</p>
              <p><strong>Term:</strong> {insurance.term}</p>
              <p><strong>Max Age:</strong> {insurance.maxAge}</p>
              <p><strong>Exclusions:</strong> {insurance.exclusions}</p>
              <button
                onClick={() => handleSelectInsurance(insurance.id)}
                className="select-insurance-button"
              >
                Select this Insurance
              </button>
            </div>
          ))}
        </div>
      )}
    </div>
  );
};

export default InsuranceInquiry;