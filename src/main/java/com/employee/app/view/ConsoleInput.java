package com.employee.app.view;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.employee.app.utils.exception.InvalidInputException;

public class ConsoleInput implements InputView {
	private static final Scanner SCANNER = new Scanner(System.in);
	private static final String PHONE_NUMBER_REGEX = "^[0-9]{2,3}-[0-9]{3,4}-[0-9]{4}$";
	private static final String EMAIL_REGEX = "(^[0-9a-zA-Z_-]+@[0-9a-zA-Z]+[.][a-zA-Z]{2,4}$)";

	@Override
	public String inputName() {
		System.out.println("이름을 입력하세요:");
		return SCANNER.nextLine();
	}

	private String validateInputInformation(String regex, String value) {
		Matcher matcher = Pattern.compile(regex).matcher(value);
		if(matcher.find())
			return matcher.group();
		throw new InvalidInputException();
	}

	@Override
	public String inputPhoneNumber() {
		System.out.println("전화번호를 입력하세요:");
		return validateInputInformation(PHONE_NUMBER_REGEX, SCANNER.nextLine());
	}

	@Override
	public String inputEmail() {
		System.out.println("이메일을 입력하세요:");
		return validateInputInformation(EMAIL_REGEX, SCANNER.nextLine());
	}

	@Override
	public String inputGrade() {
		System.out.println("직급을 입력하세요:");
		return SCANNER.nextLine();
	}

	@Override
	public int inputMenuNumber() {
		System.out.println("0 종료 1 입력 2 리스트 출력 3 상세 리스트 출력 4 수정 5 삭제");
		System.out.print("수행할 작업:");
		return Integer.parseInt(SCANNER.nextLine());
	}

	@Override
	public int inputEmployeeId() {
		System.out.println("수정 혹은 삭제할 직원번호를 입력하세요:");
		return Integer.parseInt(SCANNER.nextLine());
	}
}
