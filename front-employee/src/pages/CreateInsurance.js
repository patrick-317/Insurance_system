import React, { useState } from 'react';
import { createInsurance } from '../api/api.js';
import '../styles/CreateInsurance.css'

const CreateInsurance = () => {
  const [formData, setFormData] = useState({
    name: '',
    description: '',
    premium: '',
    coverage: '',
    term: '',
    maxAge: '',
    exclusions: '',
    insuranceType: 'LIFE_INSURANCE', // 기본값 설정
  });
  const [message, setMessage] = useState('');

  // 입력값 변경 핸들러
  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData((prevData) => ({
      ...prevData,
      [name]: value,
    }));
  };

  // 폼 제출 핸들러
  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const response = await createInsurance(formData);
      setMessage(`보험 개발 성공: ${response.message || '새 보험이 추가되었습니다.'}`);
      setFormData({
        name: '',
        description: '',
        premium: '',
        coverage: '',
        term: '',
        maxAge: '',
        exclusions: '',
        insuranceType: 'LIFE_INSURANCE',
      });
    } catch (error) {
      setMessage(error.message);
    }
  };

  return (
    <div className="create-insurance">
      <h1>보험 개발</h1>
      <form onSubmit={handleSubmit} className="insurance-form">
        <label>
          보험 이름:
          <input
            type="text"
            name="name"
            value={formData.name}
            onChange={handleChange}
            required
          />
        </label>
        <label>
          설명:
          <textarea
            name="description"
            value={formData.description}
            onChange={handleChange}
            required
          />
        </label>
        <label>
          보험료 (원):
          <input
            type="number"
            name="premium"
            value={formData.premium}
            onChange={handleChange}
            required
          />
        </label>
        <label>
          보장 금액 (원):
          <input
            type="number"
            name="coverage"
            value={formData.coverage}
            onChange={handleChange}
            required
          />
        </label>
        <label>
          기간:
          <input
            type="text"
            name="term"
            value={formData.term}
            onChange={handleChange}
            required
          />
        </label>
        <label>
          최대 가입 연령:
          <input
            type="number"
            name="maxAge"
            value={formData.maxAge}
            onChange={handleChange}
            required
          />
        </label>
        <label>
          제외 조건:
          <textarea
            name="exclusions"
            value={formData.exclusions}
            onChange={handleChange}
          />
        </label>
        <label>
          보험 유형:
          <select
            name="insuranceType"
            value={formData.insuranceType}
            onChange={handleChange}
          >
            <option value="LIFE_INSURANCE">생명 보험</option>
            <option value="DAMAGE_INSURANCE">손해 보험</option>
            <option value="THIRD_INSURANCE">제 3보험</option>
          </select>
        </label>
        <button type="submit">보험 개발</button>
      </form>
      {message && <p className="message">{message}</p>}
    </div>
  );
};

export default CreateInsurance;