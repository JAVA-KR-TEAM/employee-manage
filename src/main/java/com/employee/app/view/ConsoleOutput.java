package com.employee.app.view;

import com.employee.app.domain.Employees;

public class ConsoleOutput implements OutputView {
	private static final String lineBreak = "\n";
	private static final String longDash = "===============";
	private static final String DETAIL_EMPLOYEES_MENU = "직원번호\t이름\t전화번호\t\t\t직급\t이메일";
	private static final String EMPLOYEES_MENU = "직원번호\t이름";
	private static final String EXIT = "프로그램을 종료합니다.";

	@Override
	public void employeeList(Employees employees) {
		StringBuilder sb = new StringBuilder();
		sb.append(lineBreak);
		sb.append(EMPLOYEES_MENU + lineBreak);
		sb.append(longDash);
		System.out.println(sb.toString());
		employees.findEmployees();
	}

	@Override
	public void employeeDetailList(Employees employees) {
		StringBuilder sb = new StringBuilder();
		sb.append(lineBreak);
		sb.append(DETAIL_EMPLOYEES_MENU + lineBreak);
		sb.append(longDash).append(longDash).append(longDash).append(longDash);
		System.out.println(sb.toString());
		employees.findDetailEmployees();
	}

	@Override
	public void exitProgram() {
		System.out.println(EXIT);
	}
}
