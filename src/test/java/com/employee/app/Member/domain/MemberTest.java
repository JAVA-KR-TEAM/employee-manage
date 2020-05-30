package com.employee.app.Member.domain;

import com.employee.app.dto.MemberDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class MemberTest {

    @DisplayName("사용자 정보변경 테스트")
    @Test
    void testUpdate() {
        Member expected = Member
                .builder()
                .id(new Id("000"))
                .name(new Name("홍길동"))
                .phone(new Phone("000-0000-0000"))
                .email(new Email("test@test.com"))
                .rank(Rank.LEADER)
                .build();

        Member actual = expected.updateInformation(MemberDto.builder()
                .name(new Name("조정석"))
                .phone(new Phone("010-1111-1111"))
                .email(new Email("aaa@aaa.com"))
                .rank(Rank.MANAGER)
                .build());

        assertThat(actual).isNotNull();
        assertAll(
                () -> assertThat(actual.getId()).isEqualTo(expected.getId()),
                () -> assertThat(expected.getName()).isEqualTo("조정석"),
                () -> assertThat(expected.getPhone()).isEqualTo("010-1111-1111"),
                () -> assertThat(expected.getEmail()).isEqualTo("aaa@aaa.com"),
                () -> assertThat(expected.getRank()).isEqualTo(Rank.MANAGER)
        );
    }
}
