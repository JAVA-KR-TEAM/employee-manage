package com.employee.app.Member.domain;

import lombok.Builder;

import java.util.Objects;

@Builder
public class Member {
    private final String id;
    private final Name name;
    private final Email email;
    private final Phone phone;
    private final Rank rank;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Member)) return false;
        Member member = (Member) o;
        return Objects.equals(id, member.id) &&
                Objects.equals(name, member.name) &&
                Objects.equals(email, member.email) &&
                Objects.equals(phone, member.phone) &&
                rank == member.rank;
    }

    @Override
    public String toString() {
        return "Member{" +
                "id='" + id + '\'' +
                ", name=" + name +
                ", email=" + email +
                ", phone=" + phone +
                ", rank=" + rank +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, phone, rank);
    }
}
