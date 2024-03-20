package com.group.companytimeclockapp.dto.response;


import com.group.companytimeclockapp.entity.Team;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class TeamGetAllRespone {
    private final String name;
    private final List<String> manager;
    private final int memberCount;

    public TeamGetAllRespone(Team team) {
        this(team.getName(), team.getManagerName(), team.getEmployees()
                .size());
    }

}
