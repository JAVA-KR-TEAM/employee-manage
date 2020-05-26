package com.employee.app.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EmployeesTest {
	private Employees employees;

	@BeforeEach
	void setUp() {
		List<Employee> employeeList = Fixture.createEmployeeList();
		employees = Employees.create(employeeList);
	}

	@Test
	void numberOfEmployees() {
		assertThat(employees.numberOfEmployees()).isEqualTo(2);
	}
}