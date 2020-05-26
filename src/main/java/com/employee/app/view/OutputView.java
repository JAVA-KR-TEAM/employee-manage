package com.employee.app.view;

import com.employee.app.domain.Employees;

public interface OutputView {
	void employeeList(Employees employees);
	void employeeDetailList(Employees employees);
	void exitProgram();
}
