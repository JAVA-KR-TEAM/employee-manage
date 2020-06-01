package com.employee.app.Member.domain;

import com.employee.app.dto.MemberVo;
import lombok.*;

@Builder
@EqualsAndHashCode
@ToString
public class Employee {
    private Id id;
    private Name name;
    private Email email;
    private Phone phone;
    private Rank rank;

    public Employee updateInformation(MemberVo memberVo) {
        this.name = memberVo.getName();
        this.phone = memberVo.getPhone();
        this.email = memberVo.getEmail();
        this.rank = memberVo.getRank();

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
