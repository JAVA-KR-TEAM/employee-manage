package com.employee.app.view;

import com.employee.app.domain.Employees;

public class ConsoleOutput implements OutputView {
	private static final String lineBreak = "\n";

	@Override
	public void employeeList(Employees employees) {
		StringBuilder sb = new StringBuilder();
		sb.append(lineBreak);
		sb.append("직원번호   이름" + lineBreak);
		sb.append("===============");
		System.out.println(sb.toString());
		employees.findEmployees();
	}

	@Override
	public void employeeDetailList(Employees employees) {
		StringBuilder sb = new StringBuilder();
		sb.append(lineBreak);
		sb.append("직원번호   이름     전화번호      직급      이메일" + lineBreak);
		sb.append("==================================================");
		System.out.println(sb.toString());
		employees.findDetailEmployees();
	}

	@Override
	public void exitProgram() {
		System.out.println("프로그램을 종료합니다.");
	}
}
