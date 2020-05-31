package com.employee.app.Member.domain;

import java.util.ArrayList;
import java.util.List;

public class Members {
    private static final String REQUIRE_MEMBERS = "사용자의 값이 입력되어야합니다";
    private static final String NOT_FOUND_MEMBER = "검색 결과가 없습니다.";

    private List<Member> members;

    public Members() {
        this.members = new ArrayList<>();
    }

    public Members(List<Member> members) {
        this.members = validateUsers(members);
    }

    private List<Member> validateUsers(final List<Member> members) {
        if (members.isEmpty()) {
            throw new IllegalArgumentException(REQUIRE_MEMBERS);
        }
        return new ArrayList<>(members);
    }

    public Member findMember(String id) {
        return members.stream()
                .filter(m -> m.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(NOT_FOUND_MEMBER));
    }

    public void addMember(Member member) {
        this.members.add(member);
    }

    public List<Member> getMembers() {
        return new ArrayList<>(members);
    }

    public void remove(Member member) {
        this.members.remove(member);
    }

    public int getMemberSize() {
        return this.getMembers().size();
    }
}
