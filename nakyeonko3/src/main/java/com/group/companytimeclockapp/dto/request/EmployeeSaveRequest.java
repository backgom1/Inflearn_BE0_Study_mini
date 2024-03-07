package com.group.companytimeclockapp.dto.request;

import com.group.companytimeclockapp.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeSaveRequest {
    private String name;
    private Role role;
    private LocalDate birthday;
    private LocalDate workStartDate;
}
