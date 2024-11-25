import React, { useState, useEffect } from 'react';
import { getInsuranceRequests, approveInsuranceRequest, rejectInsuranceRequest } from '../api/api.js';

const ManageSubscriptions = () => {
  const [requests, setRequests] = useState([]); // 요청 목록
  const [selectedRequest, setSelectedRequest] = useState(null); // 선택된 요청

  // 보험 가입 요청 조회
  const fetchRequests = async () => {
    try {
      const response = await getInsuranceRequests(); // API 호출
      setRequests(response); // 요청 목록 업데이트
    } catch (error) {
      console.error('Failed to fetch requests:', error);
      alert('보험 가입 요청 조회에 실패했습니다.');
    }
  };

  // 승인 처리
  const handleApprove = async (requestId) => {
    try {
      await approveInsuranceRequest(requestId); // 승인 API 호출
      alert('가입 요청이 승인되었습니다.');
      fetchRequests(); // 요청 목록 갱신
    } catch (error) {
      console.error('Failed to approve request:', error);
      alert('가입 요청 승인에 실패했습니다.');
    }
  };

  // 거절 처리
  const handleReject = async (requestId) => {
    try {
      await rejectInsuranceRequest(requestId); // 거절 API 호출
      alert('가입 요청이 거절되었습니다.');
      fetchRequests(); // 요청 목록 갱신
    } catch (error) {
      console.error('Failed to reject request:', error);
      alert('가입 요청 거절에 실패했습니다.');
    }
  };

  // 컴포넌트 마운트 시 요청 목록 조회
  useEffect(() => {
    fetchRequests();
  }, []);

  return (
    <div>
      <h1>보험 가입 관리</h1>
      {/* 보험 가입 요청 테이블 */}
      <div>
        <h2>가입 요청 목록</h2>
        <table>
          <thead>
            <tr>
              <th>요청 ID</th>
              <th>고객 ID</th>
              <th>보험 ID</th>
              <th>가입 날짜</th>
              <th>월 납입금</th>
              <th>상태</th>
              <th>액션</th>
            </tr>
          </thead>
          <tbody>
            {requests.map((request) => (
              <tr key={request.id}>
                <td>{request.id}</td>
                <td>{request.customerId}</td>
                <td>{request.insuranceId}</td>
                <td>{request.contractDate}</td>
                <td>{request.premium}</td>
                <td>{request.contractStatus}</td>
                <td>
                  <button onClick={() => setSelectedRequest(request)}>상세 보기</button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>

      {/* 선택된 요청 상세 보기 */}
      {selectedRequest && (
        <div>
          <h2>요청 상세</h2>
          <p><strong>요청 ID:</strong> {selectedRequest.id}</p>
          <p><strong>고객 ID:</strong> {selectedRequest.customerId}</p>
          <p><strong>보험 ID:</strong> {selectedRequest.insuranceId}</p>
          <p><strong>가입 날짜:</strong> {selectedRequest.contractDate}</p>
          <p><strong>월 납입금:</strong> {selectedRequest.premium}</p>
          <p><strong>상태:</strong> {selectedRequest.contractStatus}</p>
          <button onClick={() => handleApprove(selectedRequest.id)}>승인</button>
          <button onClick={() => handleReject(selectedRequest.id)}>거절</button>
        </div>
      )}
    </div>
  );
};

export default ManageSubscriptions;