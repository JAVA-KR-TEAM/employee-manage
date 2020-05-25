package com.employee.app.view;

import java.util.List;

import com.employee.app.domain.Employee;

public class ConsoleOutput implements OutputView {

	@Override
	public void employeeList(List<Employee> employees) {
		System.out.println();
		System.out.println("직원번호   이름");
		System.out.println("===============");
		employees.stream().map(Employee::mapIdAndName).forEach(System.out::println);
		System.out.println();
	}

	@Override
	public void employeeDetailList(List<Employee> employees) {
		System.out.println();
		System.out.println("직원번호   이름     전화번호      직급      이메일");
		System.out.println("==================================================");
		employees.stream().map(Employee::mapAllFields).forEach(System.out::println);
		System.out.println();
	}

	@Override
	public void exitProgram() {
		System.out.println("프로그램을 종료합니다.");
	}
}
