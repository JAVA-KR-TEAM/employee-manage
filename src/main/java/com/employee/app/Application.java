package com.employee.app;

import com.employee.app.view.ConsoleInput;
import com.employee.app.view.ConsoleOutput;
import com.employee.app.view.controller.EmployeeController;

public class Application {
	public static void main(String[] args) {
		EmployeeController controller = new EmployeeController(new ConsoleInput(), new ConsoleOutput());
		controller.execute();
	}
}
