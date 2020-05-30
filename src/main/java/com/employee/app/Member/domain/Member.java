package com.employee.app.Member.domain;

import lombok.Builder;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Builder
public class Member {
    private final String id;
    private final Name name;
    private final Email email;
    private final Phone phone;
    private final Rank rank;

    public Member() {
        this(null, null,null, null, null);
    }

    public Member(String id, Name name, Email email, Phone phone, Rank rank) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.rank = rank;
    }


}
