package com.employee.app.domain;

import com.employee.app.domain.payload.EmployeePayload;
import com.employee.app.utils.format.Formatter;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode(of = "id")
public class Employee {
	private Integer id;
	private String name;
	private String grade;
	private String email;
	private String phoneNumber;

	@Builder
	public Employee(Integer id, String name, String grade, String email, String phoneNumber) {
		this.id = id;
		this.name = name;
		this.grade = grade;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}

	public Employee(String name, String grade, String email, String phoneNumber) {
		this.name = name;
		this.grade = grade;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String mapIdAndName() {
		return Formatter.print(id) + "\t\t" + name;
	}

	public String mapAllFields() {
		return Formatter.print(id) + "\t\t" + name + "\t" + phoneNumber + "\t" + grade + "\t" + email;
	}

	public void update(EmployeePayload payload) {
		this.phoneNumber = payload.getPhoneNumber();
		this.grade = payload.getGrade();
		this.email = payload.getEmail();
	}
}
