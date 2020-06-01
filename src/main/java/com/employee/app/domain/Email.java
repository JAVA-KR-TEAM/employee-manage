package com.employee.app.domain;

import java.util.regex.Pattern;

import com.employee.app.utils.StringUtils;
import com.employee.app.utils.exception.InvalidInputException;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public class Email {
	private static final Pattern EMAIL_REGEX = Pattern.compile("(^[0-9a-zA-Z_-]+@[0-9a-zA-Z]+[.][a-zA-Z]{2,4}$)");
	private final String email;

	public Email(String email) {
		this.email = validate(email);
	}

	private String validate(String email) {
		if(!StringUtils.isPatternMatched(email, EMAIL_REGEX).find())
			throw new InvalidInputException();
		return email;
	}

	@Override
	public String toString() {
		return email;
	}
}
