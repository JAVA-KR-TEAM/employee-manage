package com.employee.app.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.employee.app.domain.Employee;
import com.employee.app.domain.payload.EmployeePayload;

class EmployeeServiceTest {
	private EmployeeService employeeService;

	@BeforeEach
	void setUp() {
		employeeService = new EmployeeServiceImpl();
		employeeService.save(EmployeePayload.builder()
			.name("문선민")
			.email("sunmin@naver.com")
			.grade("대리")
			.phoneNumber("010-3234-5434")
			.build());
	}

	@Test
	void save() {
		employeeService.save(EmployeePayload.builder()
			.name("김철수")
			.email("chulsu@naver.com")
			.grade("차장")
			.phoneNumber("010-1234-1234")
			.build());
	}

	@Test
	void findAll() {
		List<Employee> employees = employeeService.findAll();
		assertEquals(employees.size(), 1);
	}

	@Test
	void findById() {
		Employee employee = employeeService.findById(1);
		assertNotNull(employee);
	}

	@Test
	void update() {
		String grade = "차장";
		employeeService.update(1, EmployeePayload.builder()
			.email("chulsu@naver.com")
			.grade(grade)
			.phoneNumber("010-1234-1234")
			.build());
		Employee employee = employeeService.findById(1);
		assertEquals(employee.getGrade(), grade);
	}

	@Test
	void delete() {
		employeeService.delete(1);
		List<Employee> employees = employeeService.findAll();
		assertEquals(employees.size(), 0);
	}
}