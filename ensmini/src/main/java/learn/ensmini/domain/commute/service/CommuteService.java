package learn.ensmini.domain.commute.service;

import learn.ensmini.domain.commute.domain.Commute;
import learn.ensmini.domain.commute.dto.MinuteList;
import learn.ensmini.domain.commute.dto.request.CommuteCalculateMinuteRequest;
import learn.ensmini.domain.commute.dto.request.CommuteCreateRequest;
import learn.ensmini.domain.commute.dto.response.CommuteCreateResponse;
import learn.ensmini.domain.commute.dto.response.CommuteMinuteListDto;
import learn.ensmini.domain.commute.enums.CommuteStatus;
import learn.ensmini.domain.commute.repository.CommuteJpaRepository;
import learn.ensmini.domain.commute.repository.CommuteQueryDSLRepository;
import learn.ensmini.domain.employee.domain.Employee;
import learn.ensmini.domain.employee.repository.EmployeeJpaRepository;
import learn.ensmini.domain.employee.repository.EmployeeQueryDSLRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommuteService {
    private final CommuteJpaRepository commuteJpaRepository;
    private final CommuteQueryDSLRepository commuteQueryDSLRepository;
    private final EmployeeQueryDSLRepository employeeQueryDSLRepository;
    private final EmployeeJpaRepository employeeJpaRepository;

    @Transactional
    public CommuteCreateResponse commuteEmployee(CommuteCreateRequest request) {

        Employee employee = employeeJpaRepository.findById(request.getId()).orElseThrow(IllegalArgumentException::new);

        List<Commute> commute = commuteQueryDSLRepository.existTodayCommuteByEmployee(employee, request.getTargetDateTime());

        if (!commute.isEmpty()) {
            //퇴근
            commuteJpaRepository.save(Commute.builder()
                    .employeeCommute(employee)
                    .status(CommuteStatus.CHECKOUT)
                    .registDate(request.getTargetDateTime())
                    .build());
            return CommuteCreateResponse.builder()
                    .status(200)
                    .msg("퇴근을 성공적으로 했습니다.")
                    .build();
        } else {
            // 출근
            commuteJpaRepository.save(Commute.builder()
                    .employeeCommute(employee)
                    .status(CommuteStatus.CHECKIN)
                    .registDate(request.getTargetDateTime())
                    .build());
            return CommuteCreateResponse.builder()
                    .status(200)
                    .msg("출근을 성공적으로 했습니다.")
                    .build();
        }
    }

    /**
     * 사용자에 대한
     *
     * @return
     */
    public CommuteMinuteListDto calculateWorkingTime(CommuteCalculateMinuteRequest request) {

        List<MinuteList> minuteLists = commuteQueryDSLRepository.calculateWorkMinute(request.getId());
        int sum = minuteLists.stream().mapToInt(MinuteList::getWorkingMinutes).sum();
        return CommuteMinuteListDto.builder()
                .detail(minuteLists)
                .sum(sum).build();
    }
}
