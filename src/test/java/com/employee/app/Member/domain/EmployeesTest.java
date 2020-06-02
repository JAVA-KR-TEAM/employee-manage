package com.employee.app.Member.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static com.employee.app.Member.domain.Fixture.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class EmployeesTest {

    @DisplayName("사용자 목록에 빈값인 경우 테스트")
    @Test
    void testEmpty() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Employees(new ArrayList<>()));
    }

    @DisplayName("사용자 추가 테스트")
    @Test
    void testAddMember() {
        Employees employees = twoMembers();
        employees.addMember(employee3);

        assertThat(employees.getMemberSize()).isEqualTo(3);
    }

    @DisplayName("사용자 제거 테스트")
    @Test
    void testRemoveMember() {
        Employees employees = twoMembers();
        employees.remove(employees.findMember("001"));

        assertThat(employees.getMemberSize()).isEqualTo(1);
    }

}
