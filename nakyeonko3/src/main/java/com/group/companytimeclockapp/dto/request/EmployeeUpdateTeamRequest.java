package com.group.companytimeclockapp.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeUpdateTeamRequest {
    private String teamName;
    private Long employeeId;
}
