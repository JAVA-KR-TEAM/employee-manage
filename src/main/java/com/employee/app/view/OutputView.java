package com.employee.app.view;

import com.employee.app.Member.domain.Members;

import java.util.Objects;

public class OutputView {
    private static final int MENU_END_NUMBER = 0;
    private static final String DASH = "============";
    public static final String TAB = "\t\t";

    public static void printConsole(Members members) {
        printSubMenu();

        while (true) {
            int menuNumber = InputView.askMenuNumber();

            if (!(menuNumber != MENU_END_NUMBER)) {
                break;
            }

            switch (menuNumber) {
                case 1:
                    InputView.askMemberInfo(members);
                    break;
                case 2:
                    printMembers(members);
                    break;
                case 3:
                    printMemberDetails(members);
                    break;
                case 4:
                    InputView.updateMemberInfo(members);
                    break;
                case 5:
                    InputView.removeMember(members);
                    break;
                default:
                    throw new IllegalArgumentException("올바르지 않은 메뉴번호");
            }

            printSubMenu();
        }
    }

    public static void printSubMenu() {
        StringBuilder sb = new StringBuilder();
        sb.append("0. 종료").append(System.lineSeparator());
        sb.append("1. 직원 정보 입력").append(System.lineSeparator());
        sb.append("2. 직원 리스트").append(System.lineSeparator());
        sb.append("3. 직원 상세 정보 출력").append(System.lineSeparator());
        sb.append("4. 직원 정보 수정").append(System.lineSeparator());
        sb.append("5. 직원 정보 삭제").append(System.lineSeparator());
        System.out.println(sb.toString());
    }

    public static void printMembers(Members members) {
        if (Objects.isNull(members)) {
            throw new NullPointerException("존재하지않습니다.");
        }

        System.out.println();
        System.out.println("직원번호" + TAB + "이름");
        System.out.println(DASH);

        members.getMembers().forEach(member -> {
            System.out.println(member.getId() + TAB + member.getName());
        });
    }

    public static void printMemberDetails(Members members) {
        if (Objects.isNull(members)) {
            throw new NullPointerException("존재하지않습니다.");
        }

        System.out.println();
        System.out.println("직원번호\t 이름\t 전화번호\t 직급\t 이메일");
        System.out.println("=======================================");

        members.getMembers().forEach(member -> {
            System.out.println(
                    member.getId() + TAB + member.getName() + TAB +
                    member.getPhone() + TAB + member.getRank().getValue() + TAB + member.getEmail()
            );
        });
    }

}
