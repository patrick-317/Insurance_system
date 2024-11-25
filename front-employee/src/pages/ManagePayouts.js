import React, { useState, useEffect } from 'react';
import { getInsurancePayments, approveInsurancePayment, rejectInsurancePayment } from '../api/api.js'; // API 함수 임포트

const ManagePayouts = () => {
  const [payouts, setPayouts] = useState([]); // 요청 목록
  const [selectedPayout, setSelectedPayout] = useState(null); // 선택된 요청

  // 보험금 지급 요청 조회
  const fetchPayouts = async () => {
    try {
      const response = await getInsurancePayments(); // API 호출
      setPayouts(response); // 데이터 설정
    } catch (error) {
      console.error('Failed to fetch payouts:', error);
      alert('보험금 지급 요청 조회에 실패했습니다.');
    }
  };

  // 승인 처리
  const handleApprove = async (payoutId) => {
    try {
      await approveInsurancePayment(payoutId); // API 호출
      alert('지급 요청이 승인되었습니다.');
      fetchPayouts(); // 갱신
    } catch (error) {
      console.error('Failed to approve payout:', error);
      alert('승인 처리에 실패했습니다.');
    }
  };

  // 거절 처리
  const handleReject = async (payoutId) => {
    try {
      await rejectInsurancePayment(payoutId); // API 호출
      alert('지급 요청이 거절되었습니다.');
      fetchPayouts(); // 갱신
    } catch (error) {
      console.error('Failed to reject payout:', error);
      alert('거절 처리에 실패했습니다.');
    }
  };

  // 컴포넌트가 마운트될 때 지급 요청 조회
  useEffect(() => {
    fetchPayouts();
  }, []);

  return (
    <div>
      <h1>보험금 지급 관리</h1>
      {/* 보험금 지급 요청 테이블 */}
      <div>
        <h2>지급 요청 목록</h2>
        <table>
          <thead>
            <tr>
              <th>요청 ID</th>
              <th>고객 ID</th>
              <th>보험 ID</th>
              <th>요청 날짜</th>
              <th>상태</th>
              <th>액션</th>
            </tr>
          </thead>
          <tbody>
            {payouts.map((payout) => (
              <tr key={payout.id}>
                <td>{payout.id}</td>
                <td>{payout.customerId}</td>
                <td>{payout.insuranceId}</td>
                <td>{payout.contractDate}</td>
                <td>{payout.contractStatus}</td>
                <td>
                  <button onClick={() => setSelectedPayout(payout)}>상세 보기</button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>

      {/* 선택된 지급 요청 상세 보기 */}
      {selectedPayout && (
        <div>
          <h2>요청 상세</h2>
          <p><strong>요청 ID:</strong> {selectedPayout.id}</p>
          <p><strong>고객 ID:</strong> {selectedPayout.customerId}</p>
          <p><strong>보험 ID:</strong> {selectedPayout.insuranceId}</p>
          <p><strong>요청 날짜:</strong> {selectedPayout.contractDate}</p>
          <p><strong>월 보험료:</strong> {selectedPayout.premium}</p>
          <p><strong>상태:</strong> {selectedPayout.contractStatus}</p>
          <button onClick={() => handleApprove(selectedPayout.id)}>승인</button>
          <button onClick={() => handleReject(selectedPayout.id)}>거절</button>
        </div>
      )}
    </div>
  );
};

export default ManagePayouts;