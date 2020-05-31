package com.employee.app.view;

import com.employee.app.Member.domain.*;
import com.employee.app.dto.MemberDto;

import java.util.Scanner;

public class InputView {
    private static final String MEMBER_NAME_QUESTION = "사용자 이름을 입력하세요";
    private static Scanner scanner = new Scanner(System.in);

    public static void askMemberInfo(Members members) {
        members.addMember(Member.builder()
                .id(new Id("001"))
                .phone(askMemberPhone())
                .name(askMemberName())
                .email(askMemberEmail())
                .rank(askMemberRank())
                .build());
    }

    public static void updateMemberInfo(Members members) {
        Member findMember = members.findMember(askMemberId());
        MemberDto changeMemberDto = MemberDto.builder()
                .id(new Id(findMember.getId()))
                .phone(askMemberPhone())
                .name(askMemberName())
                .email(askMemberEmail())
                .rank(askMemberRank())
                .build();

        findMember.updateInformation(changeMemberDto);
    }

    public static void removeMember(Members members) {
        Member findMember = members.findMember(askMemberId());
        members.remove(findMember);
    }

    private static Name askMemberName() {
        System.out.println(MEMBER_NAME_QUESTION);
        return new Name(scanner.nextLine());
    }

    private static Email askMemberEmail() {
        System.out.println("사용자 이메일을 입력하세요");
        return new Email(scanner.nextLine());
    }

    public static String askMemberId() {
        System.out.println("사용자 아이디를 입력하세요");
        return scanner.nextLine();
    }

    private static Phone askMemberPhone() {
        System.out.println("사용자 전화번호를 입력하세요");
        return new Phone(scanner.nextLine());
    }

    private static Rank askMemberRank() {
        System.out.println("사용자 직급을 입력하세요");
        return Rank.of(scanner.nextLine());
    }

    public static int askMenuNumber() {
        System.out.println("\t 메뉴선택 :");
        return Integer.parseInt(scanner.nextLine());
    }
}
