package com.employee.app.service;

import java.util.List;

import com.employee.app.domain.Employee;
import com.employee.app.domain.EmployeeRepository;
import com.employee.app.domain.InMemoryEmployeeRepository;
import com.employee.app.domain.payload.EmployeePayload;
import com.employee.app.utils.exception.EmployeeNotFoundException;

public class EmployeeServiceImpl implements EmployeeService {
	private final EmployeeRepository repository;

	public EmployeeServiceImpl() {
		this.repository = new InMemoryEmployeeRepository();
	}

	@Override
	public void save(EmployeePayload payload) {
		repository.save(Employee.builder()
			.name(payload.getName())
			.grade(payload.getGrade())
			.email(payload.getEmail())
			.phoneNumber(payload.getPhoneNumber())
			.build());
	}

	@Override
	public Employee findById(int employeeId) {
		return repository.findById(employeeId)
			.orElseThrow(EmployeeNotFoundException::new);
	}

	@Override
	public List<Employee> findAll() {
		return repository.findAll();
	}

	@Override
	public void delete(int employeeId) {
		repository.deleteById(employeeId);
	}

	@Override
	public void update(int employeeId, EmployeePayload payload) {
		Employee employee = findById(employeeId);
		employee.update(payload.getPhoneNumber(), payload.getGrade(), payload.getEmail());
		repository.save(employee);
	}
}
