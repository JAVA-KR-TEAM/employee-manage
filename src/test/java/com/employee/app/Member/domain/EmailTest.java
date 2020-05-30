package com.employee.app.Member.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class EmailTest {

    @DisplayName(value = "이메일이 아닌 값을 입력할 경우, IllegalArgumentException 이 발생")
    @ParameterizedTest
    @ValueSource(strings = {"aaa.com", "abc", "abc@@"})
    void testValidateEmail (final String email) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Email(email));
    }
}
