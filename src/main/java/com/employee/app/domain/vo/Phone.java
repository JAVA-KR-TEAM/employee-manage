package com.employee.app.domain.vo;

import static com.employee.app.utils.StringUtils.*;

import java.util.regex.Pattern;

import com.employee.app.utils.exception.InvalidInputException;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public class Phone {
	private static final Pattern PHONE_NUMBER_REGEX = Pattern.compile("^[0-9]{2,3}-[0-9]{3,4}-[0-9]{4}$");
	private final String phoneNumber;

	public Phone(String phoneNumber) {
		this.phoneNumber = validate(phoneNumber);
	}

	private String validate(String phoneNumber) {
		if(!isPatternMatched(phoneNumber, PHONE_NUMBER_REGEX).find())
			throw new InvalidInputException();
		return phoneNumber;
	}

	@Override
	public String toString() {
		return phoneNumber;
	}
}
