package com.employee.app.domain;

import java.util.List;

public class Employees {
	private final List<Employee> employees;

	private Employees(List<Employee> employees) {
		this.employees = employees;
	}

	public static Employees create(List<Employee> employees) {
		return new Employees(employees);
	}

	public int numberOfEmployees() {
		return employees.size();
	}

	public void findEmployees() {
		employees.stream().map(Employee::mapIdAndName).forEach(System.out::println);
	}

	public void findDetailEmployees() {
		employees.stream().map(Employee::mapAllFields).forEach(System.out::println);
	}
}
