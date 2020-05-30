package com.employee.app.Member.domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Email {
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$");
    private static final String NOT_EMAIL_PATTERN = "이메일을 다시확인해주세요.";
    private String email;

    public Email(String email) {
        this.email = validateEmail(email);
    }

    private String validateEmail(final String email) {
        if (!getMatcher(email, EMAIL_PATTERN).find()) {
            throw new IllegalArgumentException(NOT_EMAIL_PATTERN);
        }

        return email;
    }

    private Matcher getMatcher(final String name, final Pattern pattern) {
        return pattern.matcher(name);
    }

}
