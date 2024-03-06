package com.group.companytimeclockapp.service;

import com.group.companytimeclockapp.domain.Team;
import com.group.companytimeclockapp.dto.response.TeamGetAllRespone;
import com.group.companytimeclockapp.repository.TeamRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeamService {
    final private TeamRepository teamRepository;

    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @Transactional
    public void saveTeam(String name) {
        teamRepository.save(new Team(name));
    }

    @Transactional
    public List<TeamGetAllRespone> getTeams() {
        List<Team> teams = teamRepository.findAll();
        return teams.stream()
                .map(team -> new TeamGetAllRespone(team.getName(), team.getManagerName(), team.getEmployees()
                        .size()))
                .collect(Collectors.toList());
    }

}
