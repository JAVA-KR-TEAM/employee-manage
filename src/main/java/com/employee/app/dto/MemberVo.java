package com.employee.app.dto;

import com.employee.app.Member.domain.*;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class MemberVo {
    private final Id id;
    private final Name name;
    private final Email email;
    private final Phone phone;
    private final Rank rank;

}
