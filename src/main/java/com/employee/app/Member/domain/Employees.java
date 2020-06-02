package com.employee.app.Member.domain;

import java.util.ArrayList;
import java.util.List;

public class Employees {
    private static final String REQUIRE_MEMBERS = "사용자의 값이 입력되어야합니다";
    private static final String NOT_FOUND_MEMBER = "검색 결과가 없습니다.";

    private List<Employee> employees;

    public Employees() {
        this.employees = new ArrayList<>();
    }

    public Employees(List<Employee> employees) {
        this.employees = validateUsers(employees);
    }

    private List<Employee> validateUsers(final List<Employee> employees) {
        if (employees.isEmpty()) {
            throw new IllegalArgumentException(REQUIRE_MEMBERS);
        }
        return new ArrayList<>(employees);
    }

    public Employee findMember(String id) {
        return employees.stream()
                .filter(m -> m.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(NOT_FOUND_MEMBER));
    }

    public void addMember(Employee employee) {
        this.employees.add(employee);
    }

    public List<Employee> getEmployees() {
        return new ArrayList<>(employees);
    }

    public void remove(Employee employee) {
        this.employees.remove(employee);
    }

    public int getMemberSize() {
        return this.getEmployees().size();
    }
}
