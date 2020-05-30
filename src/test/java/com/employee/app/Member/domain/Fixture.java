package com.employee.app.Member.domain;

import com.employee.app.dto.MemberDto;

import java.util.Arrays;

public class Fixture {

    private Fixture() {
    }

    public static Member member1 = Member
            .builder()
            .id("000")
            .name("홍길동")
            .email("test@aaa.com")
            .rank(Rank.LEADER)
            .build();

    public static Member member2 = Member
            .builder()
            .id("001")
            .name("김유정")
            .email("test@aaa.com")
            .rank(Rank.STAFF)
            .build();

    public static Members twoMember() {
        return new Members(Arrays.asList(member1, member2));
    }

}
