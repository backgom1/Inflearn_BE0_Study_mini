package com.mini.commute.service.employee;

import com.mini.commute.dto.employee.EmployeeRequest;
import com.mini.commute.entity.employee.Employee;
import com.mini.commute.entity.team.Team;
import com.mini.commute.repository.employee.EmployeeRepository;
import com.mini.commute.repository.team.TeamRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final TeamRepository teamRepository;

    public EmployeeService(EmployeeRepository employeeRepository, TeamRepository teamRepository) {
        this.employeeRepository = employeeRepository;
        this.teamRepository = teamRepository;
    }

    @Transactional
    public void save(EmployeeRequest request) {
        Team team = teamRepository.findByName(request.getTeamName());
        if(team == null) {
            throw new IllegalArgumentException("팀이 존재하지 않습니다.");
        }
        // 먼저 Employee 객체 생성하고
        Employee employee = new Employee(request.getName(), request.getBirthday(),
                request.getWorkStartDate(), request.getRole());
        // 그 다음에 team 할당
        employee.setTeam(team);
        employeeRepository.save(employee);
    }
}
