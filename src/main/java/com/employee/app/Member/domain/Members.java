package com.employee.app.Member.domain;

import java.util.ArrayList;
import java.util.List;

public class Members {
    private static final String REQUIRE_MEMBERS = "사용자의 값이 입력되어야합니다";
    private List<Member> members;

    public List<Member> validateUsers(final List<Member> members) {
        if (members.isEmpty()) {
            throw new IllegalArgumentException(REQUIRE_MEMBERS);
        }
        return new ArrayList<>(members);
    }

    public Members(List<Member> members) {
        this.members = validateUsers(members);
    }

    public void addMember(Member member) {
        this.members.add(member);
    }

    public List<Member> getMembers() {
        return new ArrayList<>(members);
    }

    public void deleteMember(Member member) {
        this.members.remove(member);
    }

    public int getMemberSize() {
        return this.getMembers().size();
    }
}
