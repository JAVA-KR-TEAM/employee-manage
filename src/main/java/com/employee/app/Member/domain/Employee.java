package com.employee.app.Member.domain;

import com.employee.app.dto.EmployeeDto;
import lombok.*;

@Builder
@EqualsAndHashCode
@ToString
public class Employee {
    private Id id;
    private Name name;
    private Email email;
    private Phone phone;
    private Rank rank;

    public Employee updateInformation(EmployeeDto employeeDto) {
        this.name = employeeDto.getName();
        this.phone = employeeDto.getPhone();
        this.email = employeeDto.getEmail();
        this.rank = employeeDto.getRank();

        return this;
    }

    public String getId() {
        return this.id.getId();
    }

    public String getEmail() {
        return this.email.getEmail();
    }

    public String getPhone() {
        return this.phone.getPhone();
    }

    public String getName() {
        return this.name.getName();
    }

    public Rank getRank() {
        return this.rank;
    }

}
