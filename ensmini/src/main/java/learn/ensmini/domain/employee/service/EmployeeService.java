package learn.ensmini.domain.employee.service;

import learn.ensmini.domain.employee.domain.Employee;
import learn.ensmini.domain.employee.dto.request.EmployeeCreateRequest;
import learn.ensmini.domain.employee.dto.response.EmployeeCreateResponse;
import learn.ensmini.domain.employee.dto.response.EmployeeListResponseDto;
import learn.ensmini.domain.employee.exception.EmployeeException;
import learn.ensmini.domain.employee.exception.enums.EmployeeErrorEnums;
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

import static learn.ensmini.domain.employee.exception.enums.EmployeeErrorEnums.*;

/**
 * 직원에 대한 기능을 구성하는 클래스
 *
 * @author dmstjd
 * @version v0.0.1
 * @since 2024-03-07
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class EmployeeService {

    private final EmployeeJpaRepository employeeJpaRepository;
    private final TeamJpaRepository teamJpaRepository;
    private final EmployeeQueryDSLRepository queryDSLRepository;

    /**
     * 직원 생성 비지니스 로직
     *
     * @param request 직원 생성 요청 파라미터
     * @return 성공 메세지 반환
     */
    @Transactional
    public EmployeeCreateResponse save(EmployeeCreateRequest request) {

        Team team = teamJpaRepository.findTeamByName(request.getTeamName()).orElseThrow(IllegalArgumentException::new);

        Employee member = Employee.builder()
                .name(request.getName())
                .teamEmployee(team)
                .role("MEMBER")
                .birthday(request.getBirthday())
                .workStartDate(request.getWorkStartDate())
                .build();

        employeeJpaRepository.save(member);

        return EmployeeCreateResponse.builder()
                .status(200)
                .msg("직원이 생성되었습니다.")
                .build();
    }


    /**
     * 직원 조회
     *
     * @return 직원 조회 반환
     */
    @Transactional(readOnly = true)
    public List<EmployeeListResponseDto> findAllEmployee() throws EmployeeException {
        List<EmployeeListResponseDto> findEmployeeList = queryDSLRepository.findAll();
        if (findEmployeeList.isEmpty()) {
            throw new EmployeeException(NOT_FOUND_EMPLOYEE.getValue(), "직원 정보가 존재하지 않습니다.");
        }
        return queryDSLRepository.findAll();
    }
}
