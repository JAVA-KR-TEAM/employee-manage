package com.employee.app.utils.format;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class FormatterTest {

	@Test
	void format_length_SingleDigit() {
		String excepted = Formatter.print(1);
		assertEquals(excepted, "001");
	}

	@Test
	void format_length_DoubleDigit() {
		String excepted = Formatter.print(12);
		assertEquals(excepted, "012");
	}

	@Test
	void format_length_TripleDigit() {
		String excepted = Formatter.print(122);
		assertEquals(excepted, "122");
	}
}