package com.employee.app.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class EmployeeTest {

	@Test
	void compare_sameness_Employee() {
		Employee excepted = Employee.builder()
			.id(1)
			.build();

		Employee employee = Employee.builder()
			.id(1)
			.build();
		assertEquals(excepted, employee);
	}
}