package com.employee.app.domain.payload;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class EmployeePayload {
	private String name;
	private String grade;
	private String phoneNumber;
	private String email;
}
