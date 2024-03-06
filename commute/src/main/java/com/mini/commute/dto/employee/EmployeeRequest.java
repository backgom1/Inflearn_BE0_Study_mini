package com.mini.commute.dto.employee;

import com.mini.commute.entity.employee.Role;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class EmployeeRequest {
    private String name;
    private LocalDate birthday;
    private LocalDate workStartDate;
    private Role role;
    private String teamName;
}
