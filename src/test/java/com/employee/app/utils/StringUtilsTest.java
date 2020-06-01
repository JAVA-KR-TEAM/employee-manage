package com.employee.app.utils;

import static org.assertj.core.api.Assertions.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringUtilsTest {

	@DisplayName("입력 값이 공백인 경우")
	@Test
	void isBlank() {
		boolean excepted = StringUtils.isBlank(" ");
		assertThat(excepted).isTrue();
	}

	@DisplayName("이메일 정규식 검증 실패인 경우")
	@Test
	void isPatternMatched() {
		Matcher matcher = StringUtils.isPatternMatched("aaa.com",
			Pattern.compile("(^[0-9a-zA-Z_-]+@[0-9a-zA-Z]+[.][a-zA-Z]{2,4}$)"));
		assertThat(matcher.find()).isFalse();
	}
}