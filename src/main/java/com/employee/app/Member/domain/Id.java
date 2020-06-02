package com.employee.app.Member.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.Objects;

import static com.employee.app.utils.StringUtils.isBlank;
import static com.employee.app.utils.StringUtils.isGreaterThanMaximumId;

@EqualsAndHashCode
@Getter
public class Id {
    private static final String NULL_NOT_ALLOW = "공백을 입력할 수 없습니다.";
    private static final int MAXIMUM_LENGTH = 3;
    private static final String LIMIT_ID = "이상 생성될 수 없습니다.";
    private static final String NOT_ALLOWED_NUMBER = "올바르지않은 수를 입력헀습니다.";

    private final String id;

    public Id(final String id) {
        this.id = validateId(id);
    }

    private String validateId(final String id) {
        if (isBlank(id)) {
            throw new IllegalArgumentException(NULL_NOT_ALLOW);
        }

        if (isGreaterThanMaximumId(id, MAXIMUM_LENGTH)) {
            throw new IllegalArgumentException(MAXIMUM_LENGTH + LIMIT_ID);
        }
        checkLessThanZero(id);

        return id;
    }

    private void checkLessThanZero(String id) {
        try {
            Integer.parseUnsignedInt(id);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(NOT_ALLOWED_NUMBER);
        }
    }
}
