package learn.ensmini.domain.employee.service;

import learn.ensmini.domain.employee.domain.Employee;
import learn.ensmini.domain.employee.dto.request.EmployeeCreateRequest;
import learn.ensmini.domain.employee.dto.response.EmployeeCreateResponse;
import learn.ensmini.domain.employee.dto.response.EmployeeListResponseDto;
import learn.ensmini.domain.employee.repository.EmployeeJpaRepository;
import learn.ensmini.domain.employee.repository.EmployeeQueryDSLRepository;
import learn.ensmini.domain.team.domain.Team;
import learn.ensmini.domain.team.repository.TeamJpaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmployeeService {

    private final EmployeeJpaRepository employeeJpaRepository;
    private final TeamJpaRepository teamJpaRepository;
    private final EmployeeQueryDSLRepository queryDSLRepository;

    @Transactional
    public EmployeeCreateResponse save(EmployeeCreateRequest request) {

        Team team = teamJpaRepository.findTeamByName(request.getTeamName()).orElseThrow(IllegalArgumentException::new);

        Employee member = Employee.builder()
                .name(request.getName())
                .teamEmployee(team)
                .role("MEMBER")
                .birthday(request.getBirthday())
                .workStartDate(LocalDate.now())
                .build();

        employeeJpaRepository.save(member);

        return EmployeeCreateResponse.builder()
                .status(200)
                .msg("직원이 생성되었습니다.").build();
    }


    @Transactional(readOnly = true)
    public List<EmployeeListResponseDto> findAllEmployee() {
        return queryDSLRepository.findAll();
    }
}
