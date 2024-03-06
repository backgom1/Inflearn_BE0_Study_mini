package com.group.companytimeclockapp.dto.request;

import com.group.companytimeclockapp.util.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;

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
