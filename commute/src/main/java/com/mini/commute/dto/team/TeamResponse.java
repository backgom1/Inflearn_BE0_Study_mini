package com.mini.commute.dto.team;

import com.mini.commute.entity.team.Team;
import lombok.Getter;

@Getter
public class TeamResponse {
    private String name;
    private String manager;
    private int memberCount;

    public TeamResponse(Team team) {
        this.name = team.getName();
        String manager = team.pickManager();
        if(!manager.equals("")) {
            this.manager = manager;
        }
        this.memberCount = team.getEmployees().size();
    }
}
