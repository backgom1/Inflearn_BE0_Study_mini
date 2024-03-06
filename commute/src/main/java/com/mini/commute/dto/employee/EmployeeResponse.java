package com.mini.commute.dto.employee;

import com.mini.commute.entity.employee.Employee;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class EmployeeResponse {
    private String name;
    private String teamName;
    private String role;
    private LocalDate birthday;
    private LocalDate workStartDate;

    public EmployeeResponse(Employee employee) {
        this.name = employee.getName();
        this.teamName = employee.getTeam().getName();
        this.role = employee.getRole().toString();
        this.birthday = employee.getBirthday();
        this.workStartDate = employee.getWorkStartDate();
    }
}
