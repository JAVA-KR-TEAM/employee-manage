package com.employee.app.service;

import java.util.List;

import com.employee.app.domain.Employee;
import com.employee.app.domain.payload.EmployeePayload;

public interface EmployeeService {
	void save(EmployeePayload payload);
	Employee findById(int employeeId);
	List<Employee> findAll();
	void delete(int employeeId);
	void update(int employeeId, EmployeePayload payload);
}
