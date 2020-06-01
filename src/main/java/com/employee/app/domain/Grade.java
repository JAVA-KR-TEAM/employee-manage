package com.employee.app.domain;

import java.util.Arrays;

import com.employee.app.utils.exception.InvalidInputException;

public enum Grade {
	STAFF("사원"),
	PROFESSIONAL("대리"),
	SUPERVISOR("과장"),
	LEADER("차장"),
	MANAGER("부장"),
	PRESIDENT("사장");

	private String value;

	Grade(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public static Grade of(String grade) {
		return Arrays.stream(values())
			.filter(v -> v.getValue().equals(grade))
			.findFirst()
			.orElseThrow(InvalidInputException::new);
	}
}
