package com.employee.app.domain.vo;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.employee.app.utils.exception.InvalidInputException;

class PhoneTest {

	@DisplayName(value = "전화번호가 아닌 값을 입력할 경우")
	@ParameterizedTest
	@ValueSource(strings = {"11111", "010-333"})
	void testValidatePhone (String phoneNumber) {
		assertThatExceptionOfType(InvalidInputException.class)
			.isThrownBy(() -> new Phone(phoneNumber));
	}
}