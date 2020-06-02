package com.employee.app.Member.domain;

import java.util.Arrays;

public enum Rank {
    STAFF("사원"),
    PROFESSIONAL("대리"),
    SUPERVISOR("과장"),
    LEADER("차장"),
    MANAGER("부장"),
    PRESIDENT("사장");

    private String value;

    Rank(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static Rank of(String r) {
        return Arrays.stream(values())
                .filter(v -> v.getValue().equals(r))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
