package com.employee.app.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class EmployeeTest {

	@Test
	void compare_sameness_Employee() {
		Employee excepted = Employee.builder()
			.id(1)
			.name("김철수")
			.grade("차장")
			.email("chulsu@naver.com")
			.phoneNumber("010-1234-1234")
			.build();

		Employee employee = Employee.builder()
			.id(1)
			.name("김철수")
			.grade("차장")
			.email("chulsu@naver.com")
			.phoneNumber("010-1234-1234")
			.build();
		assertEquals(excepted, employee);
	}
}