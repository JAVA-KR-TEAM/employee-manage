package com.employee.app.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EmployeeRepositoryTest {
	private EmployeeRepository repository;
	private Employee employee;

	@BeforeEach
	void setUp() {
		repository = new InMemoryEmployeeRepository();
		employee = repository.save(Employee.builder()
			.name("김철수")
			.email("chulsu@naver.com")
			.grade("차장")
			.phoneNumber("010-1234-1234")
			.build());
	}

	@Test
	void save() {
		assertNotNull(employee.getId());
	}

	@Test
	void update() {
		String grade = "대리";
		String phoneNumber = "010-1111-2222";
		String email = "chulsu1@naver.com";
		employee.update(phoneNumber, grade, email);
		Employee saveEntity = repository.save(employee);
		assertEquals(saveEntity.getGrade(), grade);
		assertEquals(saveEntity.getPhoneNumber(), phoneNumber);
		assertEquals(saveEntity.getEmail(), email);
	}

	@Test
	void findAll() {
		List<Employee> excepted = repository.findAll();
		assertEquals(excepted.size(), 1);
	}

	@Test
	void findById() {
		Employee saveEmployee = repository.save(Employee.builder()
			.name("문선민")
			.phoneNumber("010-2222-5512")
			.email("sunmin@naver.com")
			.grade("주임")
			.build());
		Optional<Employee> excepted = repository.findById(2);
		assertEquals(excepted.get().getName(), saveEmployee.getName());
	}

	@Test
	void delete() {
		repository.deleteById(employee.getId());
		List<Employee> employees = repository.findAll();
		assertEquals(employees.size(), 0);
	}
}