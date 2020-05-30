package com.employee.app.Member.domain;

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
}
