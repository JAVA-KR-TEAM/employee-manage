package com.employee.app.service;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.employee.app.domain.Email;
import com.employee.app.domain.Employee;
import com.employee.app.domain.Employees;
import com.employee.app.domain.Grade;
import com.employee.app.domain.Name;
import com.employee.app.domain.Phone;
import com.employee.app.domain.payload.EmployeePayload;
import com.employee.app.utils.exception.EmployeeNotFoundException;

class EmployeeServiceTest {
	private EmployeeService employeeService;
	private Employee saveEmployee;

	@BeforeEach
	void setUp() {
		employeeService = new EmployeeServiceImpl();
		saveEmployee = employeeService.save(EmployeePayload.builder()
			.name(new Name("문선민"))
			.phone(new Phone("010-2222-5512"))
			.email(new Email("sunmin@naver.com"))
			.grade(Grade.of("사원"))
			.build());
	}

	@Test
	void save() {
		EmployeePayload payload = EmployeePayload.builder()
			.name(new Name("김철수"))
			.email(new Email("chulsu@naver.com"))
			.grade(Grade.of("차장"))
			.phone(new Phone("010-1234-1234"))
			.build();
		Employee employee = employeeService.save(payload);
		assertThat(employee.getId()).isNotNull();
	}

	@Test
	void findAll() {
		Employees employees = employeeService.findAll();
		assertEquals(employees.numberOfEmployees(), 1);
	}

	@Test
	void findById() {
		Employee employee = employeeService.findById(1);
		assertThat(saveEmployee).isEqualTo(employee);
	}

	@Test
	void findById_error() {
		assertThatExceptionOfType(EmployeeNotFoundException.class)
			.isThrownBy(() -> employeeService.findById(12));
	}

	@Test
	void update() {
		// given
		Grade grade = Grade.of("대리");
		EmployeePayload payload = EmployeePayload.builder()
			.email(new Email("chulsu@naver.com"))
			.grade(grade)
			.phone(new Phone("010-1234-1234"))
			.build();

		// when
		employeeService.update(1, payload);
		Employee employee = employeeService.findById(1);

		// then
		assertEquals(employee.getGrade(), grade);
	}

	@Test
	void delete() {
		employeeService.delete(1);
		Employees employees = employeeService.findAll();
		assertEquals(employees.numberOfEmployees(), 0);
	}
}