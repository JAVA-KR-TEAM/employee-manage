package com.employee.app.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GradeTest {

	@Test
	void grade() {
		assertThat(Grade.of("차장")).isEqualTo(Grade.LEADER);
	}
}