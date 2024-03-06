package com.group.companytimeclockapp.service;

import com.group.companytimeclockapp.domain.Employee;
import com.group.companytimeclockapp.domain.Team;
import com.group.companytimeclockapp.dto.request.EmployeeUpdateTeamRequest;
import com.group.companytimeclockapp.dto.response.TeamGetAllRespone;
import com.group.companytimeclockapp.repository.EmployeeRepository;
import com.group.companytimeclockapp.repository.TeamRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeamService {
    private TeamRepository teamRepository;
    private EmployeeRepository employeeRepository;

    public TeamService(TeamRepository teamRepository, EmployeeRepository employeeRepository) {
        this.teamRepository = teamRepository;
        this.employeeRepository = employeeRepository;
    }

    @Transactional
    public void saveTeam(String name) {
        teamRepository.save(new Team(name));
        System.out.println(teamRepository.findAll()
                .stream()
                .map(team -> team.getId() + team.getName())
                .collect(Collectors.joining(", ")));
    }

    @Transactional
    public List<TeamGetAllRespone> getTeams() {
        List<Team> teams = teamRepository.findAll();
        return teams.stream()
                .map(team -> new TeamGetAllRespone(team.getName(), team.getManagerName(), team.getEmployees()
                        .size()))
                .collect(Collectors.toList());
    }

    @Transactional
    public void updateTeamName(EmployeeUpdateTeamRequest request) {
        Employee employee = employeeRepository.findById(request.getEmployeeId())
                .orElseThrow(IllegalArgumentException::new);
        Team team = teamRepository.findByName(request.getTeamName())
                .orElseThrow(IllegalArgumentException::new);
        team.addEmployee(employee);

        System.out.println(employee.getTeam().getName());

        System.out.println(team.getEmployees()
                .stream()
                .map(employee1 -> employee1.getTeam().getName() + ":" + employee1.getName()).collect(Collectors.joining(", ")));

        System.out.println(employeeRepository.findAll()
                .stream()
                .map(employee1 -> "team:"+employee1.getTeam().getName())
                .collect(Collectors.joining(", ")));
    }

}
