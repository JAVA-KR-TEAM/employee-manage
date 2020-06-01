package com.employee.app.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class EmployeeTest {

	@Test
	void compare_sameness_Employee() {
		Employee excepted = Employee.builder()
			.id(1)
			.name(new Name("김철수"))
			.grade(Grade.of("대리"))
			.email(new Email("chulsu@naver.com"))
			.phone(new Phone("010-1234-1234"))
			.build();

		Employee employee = Employee.builder()
			.id(1)
			.name(new Name("김철수"))
			.grade(Grade.of("대리"))
			.email(new Email("chulsu@naver.com"))
			.phone(new Phone("010-1234-1234"))
			.build();
		assertEquals(excepted, employee);
	}
}