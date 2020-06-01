package com.employee.app.dto;

import com.employee.app.Member.domain.*;
import lombok.Getter;

@Getter
public class MemberVo {
    private final Id id;
    private final Name name;
    private final Email email;
    private final Phone phone;
    private final Rank rank;

    public MemberVo(Id id, Name name, Email email, Phone phone, Rank rank) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.rank = rank;
    }
}
