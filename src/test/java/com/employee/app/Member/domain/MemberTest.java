package com.employee.app.Member.domain;

import com.employee.app.dto.MemberVo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.employee.app.Member.domain.Fixture.twoMembers;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class MemberTest {

    @DisplayName("사용자 정보변경 테스트")
    @Test
    void testUpdate() {
        // given
        Members members = twoMembers();
        Member expected = members.findMember("001");

        // when
        Member actual = expected.updateInformation(
                new MemberVo(new Id(expected.getId()), new Name("조정석"), new Email("aaa@aaa.com"),
                        new Phone("010-1111-1111"), Rank.MANAGER));

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
