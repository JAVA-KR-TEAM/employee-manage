package com.employee.app.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {
	private StringUtils() {}

	public static boolean isBlank(String value) {
		if (value == null || value.isEmpty())
			return true;
		return value.trim().isEmpty();
	}

	public static Matcher isPatternMatched(String value, Pattern pattern) {
		return pattern.matcher(value);
	}
}
