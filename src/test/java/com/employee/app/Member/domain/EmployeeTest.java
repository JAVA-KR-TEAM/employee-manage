package com.employee.app.Member.domain;

import com.employee.app.dto.EmployeeDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.employee.app.Member.domain.Fixture.twoMembers;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class EmployeeTest {

    @DisplayName("사용자 정보변경 테스트")
    @Test
    void testUpdate() {
        // given
        Employees employees = twoMembers();
        Employee expected = employees.findMember("001");

        // when
        Employee actual = expected.updateInformation(
                EmployeeDto.builder().id(new Id(expected.getId()))
                        .name(new Name("조정석"))
                        .email(new Email("aaa@aaa.com"))
                        .phone(new Phone("010-1111-1111"))
                        .rank(Rank.MANAGER).build());

        // then
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
