package com.employee.app.domain.payload;

import com.employee.app.domain.Email;
import com.employee.app.domain.Grade;
import com.employee.app.domain.Name;
import com.employee.app.domain.Phone;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class EmployeePayload {
	private Name name;
	private Grade grade;
	private Email email;
	private Phone phone;
}
