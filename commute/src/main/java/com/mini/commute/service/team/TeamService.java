package com.mini.commute.service.team;

import com.mini.commute.dto.team.TeamRequest;
import com.mini.commute.dto.team.TeamResponse;
import com.mini.commute.entity.team.Team;
import com.mini.commute.repository.employee.EmployeeRepository;
import com.mini.commute.repository.team.TeamRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class TeamService {
    private final TeamRepository teamRepository;
    private final EmployeeRepository employeeRepository;

    public TeamService(TeamRepository teamRepository, EmployeeRepository employeeRepository) {
        this.teamRepository = teamRepository;
        this.employeeRepository = employeeRepository;
    }

    @Transactional
    public void saveTeam(TeamRequest request) {
        teamRepository.save(new Team(request.getName(), request.getAnnualRegisterPeriod()));
    }

    public List<TeamResponse> getTeams() {
        return teamRepository.findAll()
                .stream()
                .map(TeamResponse::new)
                .collect(Collectors.toList());
    }

    public List<TeamResponse> getTeamsByFetch() {
        return teamRepository.findAllJPQLFetch()
                .stream()
                .map(TeamResponse::new)
                .collect(Collectors.toList());
    }
}
