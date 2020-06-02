package com.employee.app.Member.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;

class PhoneTest {
    @DisplayName(value = "전화번호가 아닌 값을 입력할 경우, IllegalArgumentException 이 발생")
    @ParameterizedTest
    @ValueSource(strings = {"11111", "010-333"})
    void testValidatePhone (final String inputText) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Phone(inputText));
    }
}
