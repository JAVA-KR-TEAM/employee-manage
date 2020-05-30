package com.employee.app.view;

import com.employee.app.Member.domain.Name;

import java.util.Scanner;

public class InputView {
    private static final String MEMBER_NAME_QUESTION = "사용자 이름을 입력하세요";
    private static Scanner scanner = new Scanner(System.in);


    public static Name askMemberName() {
        System.out.println(MEMBER_NAME_QUESTION);
        return new Name(scanner.nextLine());
    }
}
