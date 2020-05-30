package com.employee.app.Member.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class MembersTest {

    @DisplayName("사용자 목록에 빈값인 경우 테스트")
    @Test
    void testEmpty() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Members(new ArrayList<>()));
    }

}
