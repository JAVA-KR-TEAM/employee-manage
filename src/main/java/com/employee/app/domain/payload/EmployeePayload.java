package com.employee.app.domain.payload;

import com.employee.app.domain.vo.Email;
import com.employee.app.domain.vo.Grade;
import com.employee.app.domain.vo.Name;
import com.employee.app.domain.vo.Phone;
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
