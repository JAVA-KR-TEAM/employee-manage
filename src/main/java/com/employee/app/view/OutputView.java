package com.employee.app.view;

import com.employee.app.Member.domain.Members;

public class OutputView {
    private static final int MENU_END_NUMBER = 0;
    private static final String DASH = "============";
    private static final String TAB = "\t\t";
    private static final String NOT_FOUND_USER = "사용자가 존재하지 않습니다.";
    private static final String NOT_MENU_NUMBER = "올바르지 않은 메뉴번호";
    private static final String DETAIL_MEMBER_MENU = "직원번호\t 이름\t 전화번호\t 직급\t 이메일";
    private static final String LONG_DASH = "=======================================";
    private static final int ADD_MEMBER_MENU = 1;
    private static final int PRINT_MEMBER_NUMBER = 2;
    private static final int PRINT_MEMBER_DETAIL_NUMBER = 3;
    private static final int UPDATE_MEMBER_INFO_NUMBER = 4;
    private static final int REMOVE_MEMBER_NUMBER = 5;
    private static final String SUBMENU_EXIT = "0. 종료";
    private static final String SUBMENU_NEW_MEMBER = "1. 직원 정보 입력";
    private static final String SUBMENU_MEMBER_LIST = "2. 직원 리스트";
    private static final String SUBMENU_MEMBER_DETAILS = "3. 직원 상세 정보 출력";
    private static final String SUBMENU_MEMBER_UPDATE = "4. 직원 정보 수정";
    private static final String SUBMENU_MEMBER_REMOVE = "5. 직원 정보 삭제";

    public static void printConsole(Members members) {
        printSubMenu();

        while (true) {
            int menuNumber = InputView.askMenuNumber();

            if (!(menuNumber != MENU_END_NUMBER)) {
                break;
            }

            switch (menuNumber) {
                case ADD_MEMBER_MENU:
                    InputView.askMemberInfo(members);
                    break;
                case PRINT_MEMBER_NUMBER:
                    printMembers(members);
                    break;
                case PRINT_MEMBER_DETAIL_NUMBER:
                    printMemberDetails(members);
                    break;
                case UPDATE_MEMBER_INFO_NUMBER:
                    InputView.updateMemberInfo(members);
                    break;
                case REMOVE_MEMBER_NUMBER:
                    InputView.removeMember(members);
                    break;
                default:
                    throw new IllegalArgumentException(NOT_MENU_NUMBER);
            }
            printSubMenu();
        }
    }

    public static void printSubMenu() {
        StringBuilder sb = new StringBuilder();
        sb.append(SUBMENU_EXIT).append(System.lineSeparator());
        sb.append(SUBMENU_NEW_MEMBER).append(System.lineSeparator());
        sb.append(SUBMENU_MEMBER_LIST).append(System.lineSeparator());
        sb.append(SUBMENU_MEMBER_DETAILS).append(System.lineSeparator());
        sb.append(SUBMENU_MEMBER_UPDATE).append(System.lineSeparator());
        sb.append(SUBMENU_MEMBER_REMOVE).append(System.lineSeparator());
        System.out.println(sb.toString());
    }

    public static void printMembers(Members members) {
        if (members.getMemberSize() == 0) {
            System.out.println(NOT_FOUND_USER);
            System.lineSeparator();
        } else {
            System.out.println();
            System.out.println("직원번호" + TAB + "이름");
            System.out.println(DASH);

            members.getMembers().forEach(member -> {
                System.out.println(member.getId() + TAB + member.getName());
            });
        }
    }

    public static void printMemberDetails(Members members) {
        if ((members.getMemberSize() == 0)) {
            System.out.println(NOT_FOUND_USER);
            System.lineSeparator();
        } else {
            System.out.println();
            System.out.println(DETAIL_MEMBER_MENU);
            System.out.println(LONG_DASH);

            members.getMembers().forEach(member -> {
                System.out.println(
                        member.getId() + TAB + member.getName() + TAB +
                                member.getPhone() + TAB + member.getRank().getValue() + TAB + member.getEmail()
                );
            });
        }

    }

}
