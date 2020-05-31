package com.employee.app.Member.domain;

import com.employee.app.utils.StringUtils;

public class IdGenerator {
    public static final String CAN_NOT_CREATE_ID = "더 이상 아이디를 만들 수 없습니다.";
    private static int count = 0;

    public static Id generate() {
        if (count > 999) {
            throw new RuntimeException(CAN_NOT_CREATE_ID);
        }
        String stringId = StringUtils.getStringId(count++);

        return new Id(stringId);
    }
}
