package com.employee.app.domain.vo;

import static com.employee.app.utils.StringUtils.*;

import java.util.regex.Pattern;

import com.employee.app.utils.exception.InvalidInputException;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public class Name {
	private static final Pattern NAME_REGEX = Pattern.compile("[a-zA-Zㄱ-ㅎㅏ-ㅣ가-힣\\s+]{1,10}");

	private final String name;

	public Name(String name) {
		this.name = validate(name);
	}

	private String validate(String name) {
		if(isBlank(name))
			throw new InvalidInputException();
		if(!isPatternMatched(name, NAME_REGEX).find())
			throw new InvalidInputException();
		return name;
	}

	@Override
	public String toString() {
		return name;
	}
}
