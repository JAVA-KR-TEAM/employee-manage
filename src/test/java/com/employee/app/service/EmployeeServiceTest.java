package com.employee.app.service;

import static com.employee.app.domain.Fixture.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.employee.app.domain.vo.Email;
import com.employee.app.domain.Employee;
import com.employee.app.domain.Employees;
import com.employee.app.domain.vo.Grade;
import com.employee.app.domain.vo.Phone;
import com.employee.app.domain.payload.EmployeePayload;
import com.employee.app.utils.exception.EmployeeNotFoundException;

class EmployeeServiceTest {
	private EmployeeService employeeService;
	private Employee saveEmployee;

	@BeforeEach
	void setUp() {
		employeeService = new EmployeeServiceImpl();
		saveEmployee = employeeService.save(createPayloadSunmin());
	}

	@Test
	void update() {
		// given
		Grade grade = Grade.of("대리");
		Email email = new Email("chulsu@naver.com");
		Phone phone = new Phone("010-1234-1234");
		EmployeePayload payload = EmployeePayload.builder()
			.email(email)
			.grade(grade)
			.phone(phone)
			.build();

		// when
		employeeService.update(1, payload);
		Employee employee = employeeService.findById(1);

		// then
		assertAll(
			() -> assertEquals(employee.getGrade(), grade),
			() -> assertEquals(employee.getPhone(), phone),
			() -> assertEquals(employee.getEmail(), email)
		);
	}

	@Test
	void save() {
		EmployeePayload payload = createPayload();
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
	void delete() {
		employeeService.delete(1);
		Employees employees = employeeService.findAll();
		assertEquals(employees.numberOfEmployees(), 0);
	}
}