package com.employee.app.Member.domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.employee.app.utils.StringUtils.isBlank;

public class Name {
    private static final String NULL_NOT_ALLOW = "공백을 입력할 수 없습니다.";
    private static final String SPECIAL_CHARACTER_NOT_ALLOW = "한글,숫자,영문 10자 이내로 작성하여 주세요.";
    private static final Pattern NAME_PATTERN = Pattern.compile("[a-zA-Zㄱ-ㅎㅏ-ㅣ가-힣\\s+]{1,10}");

    private String name;

    public Name(String name) {
        this.name = validateName(name);
    }

    private String validateName(final String name) {
        if (isBlank(name)) {
            throw new IllegalArgumentException(NULL_NOT_ALLOW);
        }

        if (!getMatcher(name, NAME_PATTERN).find()) {
            throw new IllegalArgumentException(SPECIAL_CHARACTER_NOT_ALLOW);
        }

        return name;
    }

    private Matcher getMatcher(final String name, final Pattern namePattern) {
        return namePattern.matcher(name);
    }
}
