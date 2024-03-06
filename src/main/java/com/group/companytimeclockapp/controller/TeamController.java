package com.group.companytimeclockapp.controller;

import com.group.companytimeclockapp.dto.request.EmployeeUpdateTeamRequest;
import com.group.companytimeclockapp.dto.response.TeamGetAllRespone;
import com.group.companytimeclockapp.service.TeamService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("team")
public class TeamController {
    private TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @PostMapping
    public void saveTeam(@RequestParam String name) {
        teamService.saveTeam(name);
    }

    @GetMapping
    public List<TeamGetAllRespone> getTeams(){
        return teamService.getTeams();
    }

    @PutMapping
    public void updateTeamName(@RequestBody EmployeeUpdateTeamRequest request){
        teamService.updateTeamName(request);
    }
}
