package com.employee.app.Member.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.regex.Pattern;

import static com.employee.app.utils.StringUtils.isPatternMatched;

@EqualsAndHashCode
@Getter
public class Email {
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$");
    private static final String NOT_EMAIL_PATTERN = "이메일을 다시확인해주세요.";
    private final String email;

    public Email(final String email) {
        this.email = validateEmail(email);
    }

    private String validateEmail(final String email) {
        if (!isPatternMatched(email, EMAIL_PATTERN).find()) {
            throw new IllegalArgumentException(NOT_EMAIL_PATTERN);
        }
        return email;
    }
}
