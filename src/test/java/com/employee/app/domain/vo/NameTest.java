package com.employee.app.domain.vo;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import com.employee.app.utils.exception.InvalidInputException;

class NameTest {

	@DisplayName(value = "이름에 빈 문자열 또는 null 값을 입력할 경우")
	@ParameterizedTest
	@NullAndEmptySource
	void emptyOrNull(String name) {
		assertThatExceptionOfType(InvalidInputException.class)
			.isThrownBy(() -> new Name(name));
	}

	@DisplayName(value = "이름에 영문, 한글이 아닌 값을 입력할 경우")
	@ParameterizedTest
	@ValueSource(strings = {"*", "99", "&&"})
	void notName (String name) {
		assertThatExceptionOfType(InvalidInputException.class)
			.isThrownBy(() -> new Name(name));
	}
}