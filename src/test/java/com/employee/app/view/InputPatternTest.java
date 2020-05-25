package com.employee.app.view;

import static org.junit.jupiter.api.Assertions.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InputPatternTest {
	private Pattern phoneNumberPattern;
	private Pattern emailPattern;

	@BeforeEach
	void setUp() {
		phoneNumberPattern = Pattern.compile("^[0-9]{2,3}-[0-9]{3,4}-[0-9]{4}$");
		emailPattern = Pattern.compile("(^[0-9a-zA-Z_-]+@[0-9a-zA-Z]+[.][a-zA-Z]{2,4}$)");
	}

	@Test
	void phoneNumberPatternMatches_Success() {
		String number = "010-2351-5124";
		Matcher matcher = phoneNumberPattern.matcher(number);
		assertTrue(matcher.find());
	}

	@Test
	void phoneNumberPatternMatches_Failed() {
		String number = "0100-235*-5124";
		Matcher matcher = phoneNumberPattern.matcher(number);
		assertFalse(matcher.find());
	}

	@Test
	void emailPatternMatches_Success() {
		String email = "kitty@gmail.com";
		Matcher matcher = emailPattern.matcher(email);
		assertTrue(matcher.find());
	}

	@Test
	void emailPatternMatches_Failed() {
		String email = "kitty-gmail.com";
		Matcher matcher = emailPattern.matcher(email);
		assertFalse(matcher.find());
	}
}
