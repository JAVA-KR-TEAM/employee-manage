package com.employee.app.domain;

import com.employee.app.utils.format.Formatter;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
@EqualsAndHashCode(of = "id")
public class Employee {
	private Integer id;
	private String name;
	private String grade;
	private String email;
	private String phoneNumber;

	public void setId(Integer id) {
		this.id = id;
	}

	public String mapIdAndName() {
		return Formatter.print(id) + "\t\t" + name;
	}

	public String mapAllFields() {
		return Formatter.print(id) + "\t\t" + name + "\t" + phoneNumber + "\t" + grade + "\t" + email;
	}

	public void update(String phoneNumber, String grade, String email) {
		this.phoneNumber = phoneNumber;
		this.grade = grade;
		this.email = email;
	}
}
