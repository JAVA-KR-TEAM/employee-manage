package com.employee.app.service;

import com.employee.app.domain.Employee;
import com.employee.app.domain.Employees;
import com.employee.app.domain.payload.EmployeePayload;

public interface EmployeeService {
	Employee save(EmployeePayload payload);
	Employee findById(int employeeId);
	Employees findAll();
	void delete(int employeeId);
	void update(int employeeId, EmployeePayload payload);
}
