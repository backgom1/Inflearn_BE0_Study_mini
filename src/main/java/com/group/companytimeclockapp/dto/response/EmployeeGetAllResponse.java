package com.group.companytimeclockapp.dto.response;

import com.group.companytimeclockapp.entity.Employee;
import com.group.companytimeclockapp.entity.Role;
import com.group.companytimeclockapp.entity.Team;
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
        this.teamName = isTeamNullSetDefault(employee.getTeam());
        this.role = employee.getRole();
        this.birthday = employee.getBirthday();
        this.workStartDate = employee.getWorkStartDate();
    }

    public String isTeamNullSetDefault(Team team) {
        if (team == null) {
            return "";
        }
        return team.getName();
    }


}
