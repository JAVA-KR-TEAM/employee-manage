package com.employee.app.view;

import java.util.Scanner;

import com.employee.app.domain.vo.Email;
import com.employee.app.domain.vo.Grade;
import com.employee.app.domain.vo.Name;
import com.employee.app.domain.vo.Phone;

public class ConsoleInput implements InputView {
	private static final Scanner SCANNER = new Scanner(System.in);

	@Override
	public Name inputName() {
		System.out.println("이름을 입력하세요:");
		return new Name(SCANNER.nextLine());
	}

	@Override
	public Phone inputPhoneNumber() {
		System.out.println("전화번호를 입력하세요:");
		return new Phone(SCANNER.nextLine());
	}

	@Override
	public Email inputEmail() {
		System.out.println("이메일을 입력하세요:");
		return new Email(SCANNER.nextLine());
	}

	@Override
	public Grade inputGrade() {
		System.out.println("직급을 입력하세요:");
		return Grade.of(SCANNER.nextLine());
	}

	@Override
	public int inputMenuNumber() {
		System.out.println("0 종료 1 입력 2 리스트 출력 3 상세 리스트 출력 4 수정 5 삭제");
		System.out.print("수행할 작업:");
		return Integer.parseUnsignedInt(SCANNER.nextLine());
	}

	@Override
	public int inputEmployeeId() {
		System.out.println("수정 혹은 삭제할 직원번호를 입력하세요:");
		return Integer.parseUnsignedInt(SCANNER.nextLine());
	}
}
