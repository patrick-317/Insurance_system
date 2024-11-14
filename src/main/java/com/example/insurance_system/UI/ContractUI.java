package com.example.insurance_system.UI;

import com.example.insurance_system.DTO.ContractDTO;
import com.example.insurance_system.insurance.entity.Customer;
import com.example.insurance_system.insurance.entity.Insurance;
import com.example.insurance_system.insurance.service.ContractService;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

@Component
public class ContractUI {

    private final ContractService contractService;

    public ContractUI(ContractService contractService) {
        this.contractService = contractService;
    }

    public void displayMenu() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                System.out.println("\n----------- 보험 가입 메뉴 -----------");
                System.out.println("1. 보험 상품 조회");
                System.out.println("2. 보험 가입 신청");
                System.out.println("x. 종료");
                System.out.print("선택: ");

                String choice = reader.readLine().trim();
                switch (choice) {
                    case "1":
                        viewInsuranceList(reader);
                        break;
                    case "2":
                        applyForInsurance(reader);
                        break;
                    case "x":
                        System.out.println("시스템을 종료합니다.");
                        return;
                    default:
                        System.out.println("잘못된 입력입니다. 다시 시도해주세요.");
                }
            }
        } catch (IOException e) {
            System.out.println("시스템 오류가 발생했습니다: " + e.getMessage());
        }
    }

    private void viewInsuranceList(BufferedReader reader) {
        try {
            System.out.println("\n----------- 보험 유형 선택 메뉴 -----------");
            System.out.println("1. 생명보험");
            System.out.println("2. 손해보험");
            System.out.println("3. 제3보험");
            String typeChoice = reader.readLine().trim();

            List<Insurance> insuranceList = contractService.getInsuranceListByType(typeChoice);
            if (insuranceList.isEmpty()) {
                System.out.println("선택한 유형의 보험 상품이 없습니다.");
            } else {
                System.out.println("\n--- 보험 상품 목록 ---");
                for (Insurance insurance : insuranceList) {
                    System.out.println(insurance.getName() + " : " + insurance.getDescription() + " (" + insurance.getPremium() + ")");
                }
            }
        } catch (IOException e) {
            System.out.println("입력 오류가 발생했습니다: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("유효하지 않은 보험 유형입니다. 다시 시도해주세요.");
        }
    }

    private void applyForInsurance(BufferedReader reader) {
        try {
            Customer customer = new Customer();
            System.out.print("고객 ID: ");
            customer.setId(Integer.parseInt(reader.readLine().trim()));

            System.out.print("보험 ID: ");
            int insuranceId = Integer.parseInt(reader.readLine().trim());

            Insurance insurance = new Insurance();
            insurance.setId(insuranceId);

            ContractDTO contractDTO = contractService.applyForInsurance(customer, insurance);
            System.out.println("보험 가입 신청이 완료되었습니다. 상태: " + contractDTO.getStatus());
        } catch (IOException e) {
            System.out.println("입력 오류가 발생했습니다: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("숫자를 입력해야 합니다. 다시 시도해주세요.");
        } catch (IllegalArgumentException e) {
            System.out.println("오류: " + e.getMessage());
        }
    }
}
