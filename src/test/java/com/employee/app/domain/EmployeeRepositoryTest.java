package com.employee.app.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.employee.app.domain.payload.EmployeePayload;

class EmployeeRepositoryTest {
	private EmployeeRepository repository;
	private Employee employee;

	@BeforeEach
	void setUp() {
		repository = new InMemoryEmployeeRepository();
		employee = repository.save(Fixture.createEmployeeChulsu());
	}

	@Test
	void save() {
		assertNotNull(employee.getId());
	}

	@Test
	void update() {
		// given
		String grade = "대리";
		String phoneNumber = "010-1111-2222";
		String email = "chulsu1@naver.com";
		EmployeePayload payload = EmployeePayload.builder()
			.grade(grade)
			.phoneNumber(phoneNumber)
			.email(email)
			.build();

		// when
		employee.update(payload);
		Employee saveEntity = repository.save(employee);

		// then
		assertAll(
			() -> assertEquals(saveEntity.getGrade(), grade),
			() -> assertEquals(saveEntity.getPhoneNumber(), phoneNumber),
			() -> assertEquals(saveEntity.getEmail(), email)
		);
	}

	@Test
	void findAll() {
		List<Employee> excepted = repository.findAll();
		assertThat(excepted.size()).isEqualTo(1);
	}

	@Test
	void findById() {
		Employee saveEmployee = repository.save(Fixture.createEmployeeSunmin());
		Optional<Employee> excepted = repository.findById(2);
		assertEquals(excepted.get().getName(), saveEmployee.getName());
	}

	@Test
	void delete() {
		repository.deleteById(employee.getId());
		List<Employee> employees = repository.findAll();
		assertThat(employees.size()).isEqualTo(0);
	}
}