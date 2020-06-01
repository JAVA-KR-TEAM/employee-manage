package com.employee.app.domain.vo;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.employee.app.utils.exception.InvalidInputException;

class EmailTest {

	@DisplayName("이메일이 아닌 값을 입력할 경우")
	@ParameterizedTest
	@ValueSource(strings = {"aaa.com", "abc", "abc@@"})
	void validateEmail(String email) {
		assertThatExceptionOfType(InvalidInputException.class)
			.isThrownBy(() -> new Email(email));
	}
}