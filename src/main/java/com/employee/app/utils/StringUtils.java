package com.employee.app.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {
    private StringUtils() {
    }

    public static boolean isBlank(String value) {
        if (value == null || value.isEmpty()) {
            return true;
        }
        return value.trim().isEmpty();
    }

    public static boolean isGreaterThanMaximumId(String value, int maximum) {
        if (value.length() > maximum) {
            return true;
        }
        return false;
    }

    public static String getStringId(int numberId) {
        if (numberId < 10) {
            return "00" + numberId;
        } else if (numberId < 100) {
            return "0" + numberId;
        } else {
            throw new IllegalArgumentException("사용가능한 범위를 넘었습니다.");
        }
    }

    public static Matcher isPatternMatched(final String name, final Pattern pattern) {
        return pattern.matcher(name);
    }
}
