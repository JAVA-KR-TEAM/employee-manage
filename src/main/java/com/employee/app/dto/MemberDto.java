package com.employee.app.dto;

import com.employee.app.Member.domain.Rank;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class MemberDto {
    private final String id;
    private final String name;
    private final String email;
    private final String phone;
    private final Rank rank;
}
