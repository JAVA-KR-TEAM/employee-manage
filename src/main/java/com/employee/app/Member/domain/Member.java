package com.employee.app.Member.domain;

import lombok.Builder;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Builder
public class Member {
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$");
    private static final Pattern PHONE_PATTERN = Pattern.compile("[0-9]{2,3}-[0-9]{3,4}-[0-9]{4}$");

    private static final String NOT_EMAIL_PATTERN = "이메일을 다시확인해주세요.";
    private static final String NOT_PHONE_PATTERN = "전호번호를 다시확인해주세요.";

    private final String id;
    private final Name name;
    private final String email;
    private final String phone;
    private final Rank rank;

    public Member() {
        this(null, null,null, null, null);
    }

    public Member(String id, Name name, String email, String phone, Rank rank) {
        this.id = id;
        this.name = name;
        this.email = validateEmail(email);
        this.phone = validatePhone(phone);
        this.rank = rank;
    }

    private String validateEmail(final String email) {
        if (!getMatcher(email, EMAIL_PATTERN).find()) {
            throw new IllegalArgumentException(NOT_EMAIL_PATTERN);
        }

        return email;
    }

    private String validatePhone(final String phone) {
        if (!getMatcher(phone, PHONE_PATTERN).find()) {
            throw new IllegalArgumentException(NOT_PHONE_PATTERN);
        }

        return phone;
    }

    private Matcher getMatcher(final String phone, final Pattern phonePattern) {
        return phonePattern.matcher(phone);
    }
}
