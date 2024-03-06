package com.group.companytimeclockapp.service;

import com.group.companytimeclockapp.domain.Employee;
import com.group.companytimeclockapp.domain.Team;
import com.group.companytimeclockapp.dto.request.EmployeeSaveRequest;
import com.group.companytimeclockapp.repository.EmployeeRepository;
import com.group.companytimeclockapp.repository.TeamRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        System.out.println(employeeRepository.findAll()
                .stream()
                .map(employee -> "{이름:"+employee.getName()+", "+"직무:"+employee.getRole()+"}")
                .collect(Collectors.joining(", ")));
    }

    @Transactional
    public void updateEmployeeTeam(String teamName, Long employeeId) {
        Employee employee= employeeRepository.findById(employeeId)
                .orElseThrow(IllegalArgumentException::new);

        Team team = teamRepository.findByName(teamName)
                .orElseThrow(IllegalArgumentException::new);

        employee.updateTeamName(team);
    }
}
