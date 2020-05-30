package com.employee.app.Member.domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Phone {
    private static final Pattern PHONE_PATTERN = Pattern.compile("[0-9]{2,3}-[0-9]{3,4}-[0-9]{4}$");
    private static final String NOT_PHONE_PATTERN = "전호번호를 다시확인해주세요.";

    private final String phone;

    public Phone(String phone) {
        this.phone = validatePhone(phone);
    }

    private String validatePhone(final String phone) {
        if (!getMatcher(phone, PHONE_PATTERN).find()) {
            throw new IllegalArgumentException(NOT_PHONE_PATTERN);
        }

        return phone;
    }

    private Matcher getMatcher(final String phone, final Pattern pattern) {
        return pattern.matcher(phone);
    }


}
