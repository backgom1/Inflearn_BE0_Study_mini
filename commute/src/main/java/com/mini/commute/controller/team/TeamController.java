package com.mini.commute.controller.team;

import com.mini.commute.common.ResponseData;
import com.mini.commute.dto.team.TeamRequest;
import com.mini.commute.dto.team.TeamResponse;
import com.mini.commute.service.team.TeamService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class TeamController {
    private final TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @PostMapping("/teams")
    public ResponseEntity<ResponseData> saveTeam(@RequestBody TeamRequest request) {
        teamService.saveTeam(request);
        ResponseData responseData = new ResponseData(200, request);
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }

    @GetMapping("/teams")
    public ResponseEntity<ResponseData> getAllTeams() {
        List<TeamResponse> teamResponses = teamService.getTeamsByFetch();
        ResponseData responseData = new ResponseData(200, teamResponses);
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }
}
