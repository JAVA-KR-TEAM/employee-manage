package com.employee.app.Member.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;

class MemberTest {
    private static final long ID = 1L;
    private static final String NAME = "JOHN";
    private static final String EMAIL = "test@test.com";
    private static final String PHONE = "010-0000-0000";

    @DisplayName(value = "이름에 빈 문자열 또는 null 값을 입력할 경우, IllegalArgumentException 이 발생")
    @ParameterizedTest
    @NullAndEmptySource
    void testEmptyOrNull(final String textInput) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Member(ID, textInput, EMAIL, PHONE, Rank.STAFF));
    }

    @DisplayName(value = "이름에 영문, 한글이 아닌 값을 입력할 경우, IllegalArgumentException 이 발생")
    @ParameterizedTest
    @ValueSource(strings = {"*", "99", "&&"})
    void testNotName (final String name) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Member(ID, name, EMAIL, PHONE, Rank.STAFF));
    }

    @DisplayName(value = "이메일이 아닌 값을 입력할 경우, IllegalArgumentException 이 발생")
    @ParameterizedTest
    @ValueSource(strings = {"aaa.com", "abc", "abc@@"})
    void testValidateEmail (final String email) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Member(ID, NAME, email, PHONE, Rank.STAFF));
    }

    @DisplayName(value = "전화번호가 아닌 값을 입력할 경우, IllegalArgumentException 이 발생")
    @ParameterizedTest
    @ValueSource(strings = {"11111", "010-333"})
    void testValidatePhone (final String phone) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Member(ID, NAME, EMAIL, phone, Rank.STAFF));
    }

}
