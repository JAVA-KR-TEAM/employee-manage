package com.employee.app.domain;

import com.employee.app.domain.payload.EmployeePayload;
import com.employee.app.domain.vo.Email;
import com.employee.app.domain.vo.Grade;
import com.employee.app.domain.vo.Name;
import com.employee.app.domain.vo.Phone;
import com.employee.app.utils.format.Formatter;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@Builder
@EqualsAndHashCode(of = "id")
public class Employee {
	private Integer id;
	private Name name;
	private Grade grade;
	private Email email;
	private Phone phone;

	public void setId(Integer id) {
		this.id = id;
	}

	public String mapIdAndName() {
		return Formatter.print(id) + "\t\t" + name;
	}

	public String mapAllFields() {
		return Formatter.print(id) + "\t\t" + name + "\t" + phone + "\t" + grade.getValue() + "\t" + email;
	}

	public void update(EmployeePayload payload) {
		this.phone = payload.getPhone();
		this.grade = payload.getGrade();
		this.email = payload.getEmail();
	}
}
