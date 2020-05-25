package com.employee.app.view;

import java.util.List;

import com.employee.app.domain.Employee;

public interface OutputView {
	void employeeList(List<Employee> employees);
	void employeeDetailList(List<Employee> employees);
	void exitProgram();
}
