package com.group.companytimeclockapp.service;

import com.group.companytimeclockapp.entity.Employee;
import com.group.companytimeclockapp.entity.Team;
import com.group.companytimeclockapp.dto.request.EmployeeSaveRequest;
import com.group.companytimeclockapp.dto.response.EmployeeGetAllResponse;
import com.group.companytimeclockapp.repository.EmployeeRepository;
import com.group.companytimeclockapp.repository.TeamRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final TeamRepository teamRepository;

    public EmployeeService(EmployeeRepository employeeRepository, TeamRepository teamRepository) {
        this.employeeRepository = employeeRepository;
        this.teamRepository = teamRepository;
    }

    @Transactional
    public void saveEmployee(EmployeeSaveRequest request) {
        employeeRepository.save(new Employee(request));
    }

    @Transactional
    public void updateEmployeeTeam(String teamName, Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(IllegalArgumentException::new);

        Team team = teamRepository.findByName(teamName)
                .orElseThrow(IllegalArgumentException::new);

        employee.updateTeamName(team);
    }

    @Transactional(readOnly = true)
    public List<EmployeeGetAllResponse> getAll() {
        return employeeRepository.findAll()
                .stream()
                .map(EmployeeGetAllResponse::new)
                .collect(Collectors.toList());
    }
}
