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
    return response.data;
  } catch (error) {
    console.error('Payout request failed:', error);
    alert('Failed to request payout. Please try again.');
    return null;
  }
};