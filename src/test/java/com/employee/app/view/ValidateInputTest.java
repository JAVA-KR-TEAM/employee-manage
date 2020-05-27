package com.employee.app.view;

import static org.junit.jupiter.api.Assertions.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.jupiter.api.Test;

import com.employee.app.utils.exception.InvalidInputException;

public class ValidateInputTest {
	private static final Pattern PHONE_NUMBER_REGEX = Pattern.compile("^[0-9]{2,3}-[0-9]{3,4}-[0-9]{4}$");
	private static final Pattern EMAIL_REGEX = Pattern.compile("(^[0-9a-zA-Z_-]+@[0-9a-zA-Z]+[.][a-zA-Z]{2,4}$)");

	private String validateInputInformation(Pattern regex, String value) {
		Matcher matcher = regex.matcher(value);
		if(matcher.find())
			return matcher.group();
		throw new InvalidInputException();
	}

	@Test
	void phoneNumberPatternMatches_Success() {
		String phoneNumber = "010-2351-5124";
		String excepted = validateInputInformation(PHONE_NUMBER_REGEX, phoneNumber);
		assertEquals(excepted, phoneNumber);
	}

	@Test
	void phoneNumberPatternMatches_Failed() {
		String phoneNumber = "0100-235*-5124";
		assertThrows(InvalidInputException.class,
			() -> validateInputInformation(PHONE_NUMBER_REGEX, phoneNumber));
	}

	@Test
	void emailPatternMatches_Success() {
		String email = "kitty@gmail.com";
		String excepted = validateInputInformation(EMAIL_REGEX, email);
		assertEquals(excepted, email);
	}

	@Test
	void emailPatternMatches_Failed() {
		String email = "kitty-gmail.com";
		assertThrows(InvalidInputException.class,
			() -> validateInputInformation(EMAIL_REGEX, email));
	}
}
