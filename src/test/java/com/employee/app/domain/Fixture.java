package com.employee.app.domain;

import java.util.Arrays;
import java.util.List;

public class Fixture {
	private Fixture() {}

	public static Employee createEmployeeChulsu() {
		return Employee.builder()
			.name("김철수")
			.email("chulsu@naver.com")
			.grade("차장")
			.phoneNumber("010-1234-1234")
			.build();
	}

	public static Employee createEmployeeSunmin() {
		return Employee.builder()
			.name("문선민")
			.phoneNumber("010-2222-5512")
			.email("sunmin@naver.com")
			.grade("주임")
			.build();
	}

	public static List<Employee> createEmployeeList() {
		return Arrays.asList(
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
}
