package com.employee.app.Member.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RankTest {

    @Test
    void testRank() {
        assertThat(Rank.of("차장")).isEqualTo(Rank.LEADER);
    }
}
