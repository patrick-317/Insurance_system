// src/api.js
import axios from 'axios';

const API_BASE_URL = 'http://localhost:8080'; // 실제 API URL로 변경하세요

// 보험 개발 API 호출 함수
export const createInsurance = async (insuranceData) => {
  try {
    const response = await axios.post(`${API_BASE_URL}/insurance/create`, insuranceData);
    console.log('Insurance created successfully:', response.data);
    return response.data;
  } catch (error) {
    console.error('Failed to create insurance:', error);
    throw new Error('보험 개발에 실패했습니다. 다시 시도해주세요.');
  }
};

// 보험 가입 요청 조회
export const getInsuranceRequests = async () => {
  try {
    const response = await axios.get(`${API_BASE_URL}/underwriting/pending`);
    console.log('Insurance requests retrieved successfully:', response.data);
    return response.data;
  } catch (error) {
    console.error('Failed to retrieve insurance requests:', error);
    throw new Error('보험 가입 요청 조회에 실패했습니다. 다시 시도해주세요.');
  }
};

// 보험 가입 승인
export const approveInsuranceRequest = async (contractId) => {
  try {
    const response = await axios.put(`${API_BASE_URL}/underwriting/approve/${contractId}`);
    console.log('Insurance request approved successfully:', response.data);
    return response.data;
  } catch (error) {
    console.error('Failed to approve insurance request:', error);
    throw new Error('보험 가입 승인이 실패했습니다. 다시 시도해주세요.');
  }
};

// 보험 가입 거절
export const rejectInsuranceRequest = async (requestId) => {
  try {
    const response = await axios.put(`${API_BASE_URL}/underwriting/reject/${requestId}`);
    console.log('Insurance request rejected successfully:', response.data);
    return response.data;
  } catch (error) {
    console.error('Failed to reject insurance request:', error);
    throw new Error('보험 가입 거절이 실패했습니다. 다시 시도해주세요.');
  }
};

// 보험금 지급 조회
export const getInsurancePayments = async () => {
  try {
    const response = await axios.get(`${API_BASE_URL}/api/payments`);
    console.log('Insurance payments retrieved successfully:', response.data);
    return response.data;
  } catch (error) {
    console.error('Failed to retrieve insurance payments:', error);
    throw new Error('보험금 지급 조회에 실패했습니다. 다시 시도해주세요.');
  }
};

// 보험금 지급 승인
export const approveInsurancePayment = async (id) => {
  try {
    const response = await axios.post(`${API_BASE_URL}/api/payments/approve/${id}`);
    console.log('Insurance payment approved successfully:', response.data);
    return response.data;
  } catch (error) {
    console.error('Failed to approve insurance payment:', error);
    throw new Error('보험금 지급 승인이 실패했습니다. 다시 시도해주세요.');
  }
};

// 보험금 지급 거절
export const rejectInsurancePayment = async (id) => {
  try {
    const response = await axios.post(`${API_BASE_URL}/api/payments/reject/${id}`);
    console.log('Insurance payment rejected successfully:', response.data);
    return response.data;
  } catch (error) {
    console.error('Failed to reject insurance payment:', error);
    throw new Error('보험금 지급 거절이 실패했습니다. 다시 시도해주세요.');
  }
};