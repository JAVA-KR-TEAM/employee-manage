package com.employee.app.Member.domain;

import com.employee.app.dto.MemberDto;
import lombok.*;

@Builder
@EqualsAndHashCode
@ToString
public class Member {
    private Id id;
    private Name name;
    private Email email;
    private Phone phone;
    private Rank rank;

    public Member updateInformation(MemberDto memberDto) {
        this.name = memberDto.getName();
        this.phone = memberDto.getPhone();
        this.email = memberDto.getEmail();
        this.rank = memberDto.getRank();

        return this;
    }

    public String getId() {
        return this.id.getId();
    }

    public String getEmail() {
        return this.email.getEmail();
    }

    public String getPhone() {
        return this.phone.getPhone();
    }

    public String getName() {
        return this.name.getName();
    }

    public Rank getRank() {
        return this.rank;
    }

}
