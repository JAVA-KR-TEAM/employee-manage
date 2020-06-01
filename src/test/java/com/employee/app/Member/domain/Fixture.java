package com.employee.app.Member.domain;

import java.util.Arrays;

public class Fixture {

    private Fixture() {
    }

    public static Employee employee1 = Employee
            .builder()
            .id(new Id("000"))
            .name(new Name("홍길동"))
            .email(new Email("test@test.com"))
            .rank(Rank.LEADER)
            .build();

    public static Employee employee2 = Employee
            .builder()
            .id(new Id("001"))
            .name(new Name("김유정"))
            .email(new Email("test@test.com"))
            .rank(Rank.STAFF)
            .build();

    public static Employee employee3 = Employee
            .builder()
            .id(new Id("002"))
            .name(new Name("박보검"))
            .email(new Email("test@test.com"))
            .rank(Rank.PROFESSIONAL)
            .build();

    public static Employees twoMembers() {
        return new Employees(Arrays.asList(employee1, employee2));
    }

}
