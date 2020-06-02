package com.employee.app.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.employee.app.domain.Employees;
import com.employee.app.domain.Fixture;

class OutputViewTest {
	private Employees employees;
	private OutputView outputView;

	@BeforeEach
	void setUp() {
		outputView = new ConsoleOutput();
		employees = Employees.create(Fixture.createEmployeeList());
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