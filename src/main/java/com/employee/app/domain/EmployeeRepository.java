package com.employee.app.domain;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository {
	Optional<Employee> findById(Integer employeeId);
	List<Employee> findAll();
	Employee save(Employee entity);
	void deleteById(Integer employeeId);
}
