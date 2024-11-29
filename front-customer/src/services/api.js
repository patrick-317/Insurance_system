// src/api.js
import axios from 'axios';

const API_BASE_URL = 'http://localhost:8080'; // 실제 API URL로 변경하세요

// 로그인 요청
export const login = async (email, password) => {
  try {
    const response = await axios.post(`${API_BASE_URL}/login/main`, {
      email,
      password,
    });
    const { token } = response.data;
    console.log('Login successful:', token);
    return token;
  } catch (error) {
    console.error('Login failed:', error);
    return null;
  }
};

// 보험 가입 요청
export const subscribe = async (formData) => {
  try {
    const response = await axios.post(`${API_BASE_URL}/contracts/apply`, formData, {
      headers: {
        'Content-Type': 'application/json',
      },
    });
    console.log('Subscription successful:', response.data);
    return response.data;
  } catch (error) {
    console.error('Subscription failed:', error.response?.data || error.message);
    alert('Subscription failed. Please try again.');
    return null;
  }
};

export const fetchInsuranceDetails = async (requestBody) => {
  try {
    const response = await axios.post(
      `${API_BASE_URL}/contracts/insurance`,
      requestBody,
      {
        headers: {
          'Content-Type': 'application/json',
        },
      }
    );
    console.log('Fetched insurance details:', response.data);
    return response.data;
  } catch (error) {
    console.error('Error fetching insurance details:', error.response?.data || error.message);
    throw error;
  }
};

// 보험금 지급 요청
export const requestPayout = async (customerId, insuranceId) => {
  try {
    const response = await axios.post(`${API_BASE_URL}/api/payments/request`, {
      customerId,
      insuranceId,
    });

    console.log('Payout request successful:', response.data);
    return response.data; // JSON 데이터 반환
  } catch (error) {
    console.error('Payout request failed:', error.response?.data || error.message);
    throw error.response?.data || new Error('Unexpected error occurred.');
  }
};

// **여기서부터 새로운 함수 추가**

// 계약 목록 조회
export const fetchContracts = async () => {
  try {
    const response = await axios.get(`${API_BASE_URL}/requestInvestment/contracts`);
    console.log('Contracts fetched:', response.data);
    return response.data;
  } catch (error) {
    console.error('Error fetching contracts:', error);
    throw error;
  }
};

// 사고 조사 요청
export const requestAccidentInvestigation = async (contractId) => {
  try {
    const response = await axios.post(
      `${API_BASE_URL}/requestInvestment/contracts/${contractId}/request`
    );
    console.log('Accident investigation requested:', response.data);
    return response.data; // 서버로부터의 메시지 반환
  } catch (error) {
    console.error('Error requesting accident investigation:', error);
    throw error;
  }
};