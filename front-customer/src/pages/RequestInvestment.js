// src/RequestInvestment.js
import React, { useEffect, useState } from 'react';
import { fetchContracts, requestAccidentInvestigation } from '../services/api';
import '../styles/requestInvestment.css'

function RequestInvestment() {
  const [contracts, setContracts] = useState([]);

  // 컴포넌트가 마운트될 때 계약 목록을 가져옵니다.
  useEffect(() => {
    loadContracts();
  }, []);

  // 계약 목록을 가져오는 함수
  const loadContracts = async () => {
    try {
      const data = await fetchContracts();
      setContracts(data);
    } catch (error) {
      console.error('계약 목록을 가져오는 중 오류 발생:', error);
      alert('계약 목록을 가져오는 중 오류가 발생했습니다.');
    }
  };

  // 사고 조사 요청을 보내는 함수
  const handleRequestInvestigation = async (contractId) => {
    try {
      const message = await requestAccidentInvestigation(contractId);
      alert(message); // 서버로부터의 메시지 출력
    } catch (error) {
      console.error('사고 조사 요청 중 오류 발생:', error);
      alert('사고 조사 요청에 실패하였습니다.');
    }
  };

  return (
    <div>
      <h1>계약 목록</h1>
      <table>
        <thead>
          <tr>
            <th>계약 ID</th>
            <th>고객 ID</th>
            <th>보험 ID</th>
            <th>계약 날짜</th>
            <th>보험료</th>
            <th>상태</th>
            <th>조사 요청</th>
          </tr>
        </thead>
        <tbody>
          {contracts.map((contract) => (
            <tr key={contract.id}>
              <td>{contract.id}</td>
              <td>{contract.customerId}</td>
              <td>{contract.insuranceId}</td>
              <td>{contract.contractDate}</td>
              <td>{contract.premium}</td>
              <td>{contract.contractStatus || 'N/A'}</td>
              <td>
                <button onClick={() => handleRequestInvestigation(contract.id)}>
                  사고 조사 요청
                </button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default RequestInvestment;