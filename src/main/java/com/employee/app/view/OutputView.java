package com.employee.app.view;

import com.employee.app.Member.domain.Employees;

public class OutputView {
    private static final int MENU_END_NUMBER = 0;
    private static final String DASH = "============";
    private static final String TAB = "\t\t";
    private static final String NOT_FOUND_USER = "사용자가 존재하지 않습니다.";
    private static final String NOT_MENU_NUMBER = "올바르지 않은 메뉴번호";
    private static final String DETAIL_MEMBER_MENU = "직원번호\t 이름\t 전화번호\t 직급\t 이메일";
    private static final String LONG_DASH = "=======================================";
    private static final int ADD_MEMBER_NUMBER = 1;
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

    public static void printConsole(Employees employees) {
        printSubMenu();

        while (true) {
            int menuNumber = InputView.askMenuNumber();

            if (isExitNumber(menuNumber)) {
                break;
            }

            switch (menuNumber) {
                case ADD_MEMBER_NUMBER:
                    InputView.askMemberInfo(employees);
                    break;
                case PRINT_MEMBER_NUMBER:
                    printMembers(employees);
                    break;
                case PRINT_MEMBER_DETAIL_NUMBER:
                    printMemberDetails(employees);
                    break;
                case UPDATE_MEMBER_INFO_NUMBER:
                    InputView.updateMemberInfo(employees);
                    break;
                case REMOVE_MEMBER_NUMBER:
                    InputView.removeMember(employees);
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

    public static void printMembers(Employees employees) {
        if (hasEmployees(employees)) {
            System.out.println();
            System.out.println("직원번호" + TAB + "이름");
            System.out.println(DASH);

            employees.getEmployees().forEach(member -> {
                System.out.println(member.getId() + TAB + member.getName());
            });
        } else {
            printNotFoundEmployee();
        }
    }

    public static void printMemberDetails(Employees employees) {
        if (hasEmployees(employees)) {
            System.out.println();
            System.out.println(DETAIL_MEMBER_MENU);
            System.out.println(LONG_DASH);

            employees.getEmployees().forEach(member -> {
                System.out.println( member.getId() + TAB + member.getName() +
                        TAB + member.getPhone() + TAB + member.getRank().getValue() + TAB + member.getEmail()
                );
            });
        } else {
            printNotFoundEmployee();
        }
    }

    private static boolean hasEmployees(Employees employees) {
        return employees.getMemberSize() > 0;
    }

    private static boolean isExitNumber(int menuNumber) {
        if (!(menuNumber != MENU_END_NUMBER)) {
            return true;
        }
        return false;
    }

    private static void printNotFoundEmployee() {
        System.out.println(NOT_FOUND_USER);
        System.lineSeparator();
    }
}
