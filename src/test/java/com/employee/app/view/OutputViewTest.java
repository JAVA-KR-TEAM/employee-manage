package com.employee.app.view;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.employee.app.domain.Employee;

class OutputViewTest {
	private List<Employee> employees;
	private OutputView outputView;

	@BeforeEach
	void setUp() {
		outputView = new ConsoleOutput();
		employees = Arrays.asList(
			Employee.builder()
				.id(1)
				.name("김철수")
				.grade("차장")
				.email("chulsu@naver.com")
				.phoneNumber("010-1234-1234")
				.build(),
			Employee.builder()
				.id(2)
				.name("문선민")
				.phoneNumber("010-2222-5512")
				.email("sunmin@naver.com")
				.grade("주임")
				.build()
		);
	}

	@Test
	void employeeList() {
		outputView.employeeList(employees);
	}

	@Test
	void employeeDetailList() {
		outputView.employeeDetailList(employees);
	}
}