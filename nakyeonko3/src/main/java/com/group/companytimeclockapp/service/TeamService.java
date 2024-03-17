package com.group.companytimeclockapp.service;

import com.group.companytimeclockapp.entity.Team;
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

    @Transactional(readOnly = true)
    public List<TeamGetAllRespone> getTeams() {
        return teamRepository.findAll().stream()
                .map(TeamGetAllRespone::new)
                .collect(Collectors.toList());
    }

}
