package com.employee.app.service;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.employee.app.domain.Employee;
import com.employee.app.domain.Employees;
import com.employee.app.domain.payload.EmployeePayload;
import com.employee.app.utils.exception.EmployeeNotFoundException;

class EmployeeServiceTest {
	private EmployeeService employeeService;
	private Employee saveEmployee;

	@BeforeEach
	void setUp() {
		employeeService = new EmployeeServiceImpl();
		saveEmployee = employeeService.save(EmployeePayload.builder()
			.name("문선민")
			.email("sunmin@naver.com")
			.grade("대리")
			.phoneNumber("010-3234-5434")
			.build());
	}

	@Test
	void save() {
		EmployeePayload payload = EmployeePayload.builder()
			.name("김철수")
			.email("chulsu@naver.com")
			.grade("차장")
			.phoneNumber("010-1234-1234")
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
		assertThrows(EmployeeNotFoundException.class,
			() -> employeeService.findById(12));
	}

	@Test
	void update() {
		// given
		String grade = "차장";
		EmployeePayload payload = EmployeePayload.builder()
			.email("chulsu@naver.com")
			.grade(grade)
			.phoneNumber("010-1234-1234")
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