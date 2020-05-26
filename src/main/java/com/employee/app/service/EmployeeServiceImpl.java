package com.employee.app.service;

import com.employee.app.domain.Employee;
import com.employee.app.domain.EmployeeRepository;
import com.employee.app.domain.Employees;
import com.employee.app.domain.InMemoryEmployeeRepository;
import com.employee.app.domain.payload.EmployeePayload;
import com.employee.app.utils.exception.EmployeeNotFoundException;

public class EmployeeServiceImpl implements EmployeeService {
	private final EmployeeRepository repository;

	public EmployeeServiceImpl() {
		this.repository = new InMemoryEmployeeRepository();
	}

	@Override
	public Employee save(EmployeePayload payload) {
		return repository.save(
			new Employee(
				payload.getName(),
				payload.getGrade(),
				payload.getEmail(),
				payload.getPhoneNumber()));
	}

	@Override
	public Employee findById(int employeeId) {
		return repository.findById(employeeId)
			.orElseThrow(EmployeeNotFoundException::new);
	}

	@Override
	public Employees findAll() {
		return Employees.create(repository.findAll());
	}

	@Override
	public void delete(int employeeId) {
		repository.deleteById(employeeId);
	}

	@Override
	public void update(int employeeId, EmployeePayload payload) {
		Employee employee = findById(employeeId);
		employee.update(payload);
		repository.save(employee);
	}
}
