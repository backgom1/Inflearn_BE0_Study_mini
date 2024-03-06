package com.group.companytimeclockapp.dto.response;

import com.group.companytimeclockapp.domain.Employee;
import com.group.companytimeclockapp.domain.Team;
import com.group.companytimeclockapp.util.Role;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class EmployeeGetAllResponse {
    final private String name;
    final private String teamName;
    final private Role role;
    final private LocalDate birthday;
    final private LocalDate workStartDate;

    public EmployeeGetAllResponse(Employee employee) {
        this.name = employee.getName();
        this.teamName = setDefaultTeamIfNull(employee.getTeam());
        this.role = employee.getRole();
        this.birthday = employee.getBirthday();
        this.workStartDate = employee.getWorkStartDate();
    }

    public String setDefaultTeamIfNull(Team team) {
        if (team == null) {
            return "";
        } else {
            return team.getName();
        }
    }
}
