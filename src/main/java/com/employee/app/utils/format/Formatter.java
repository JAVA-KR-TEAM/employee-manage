package com.employee.app.utils.format;

public class Formatter {
	private Formatter() {}

	public static String print(Integer employeeId) {
		if (employeeId < 10) {
			return "00" + employeeId;
		} else if (employeeId < 100) {
			return "0" + employeeId;
		}
		return Integer.toString(employeeId);
	}
}
