package learn.ensmini.domain.employee.controller;

import jakarta.validation.Valid;
import learn.ensmini.domain.employee.dto.request.EmployeeCreateRequest;
import learn.ensmini.domain.employee.dto.response.EmployeeCreateResponse;
import learn.ensmini.domain.employee.dto.response.EmployeeListResponseDto;
import learn.ensmini.domain.employee.exception.EmployeeException;
import learn.ensmini.domain.employee.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 직원생성 및 조회를 위한 클래스입니다.
 * @author dmstjd
 * @since 2024-03-07
 * @version v0.0.1
 */
@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class EmployeeController {

    private final EmployeeService employeeService;

    /**
     * 직원 생성을 위한 컨트롤러 메서드
     * @param request 직원 생성을 위한 파라미터 객체
     * @return 성공 메세지
     */
    @PostMapping("/employee")
    @ResponseStatus(HttpStatus.OK)
    public EmployeeCreateResponse saveEmployee(@RequestBody @Valid EmployeeCreateRequest request) throws EmployeeException {
       return employeeService.save(request);
    }

    /**
     * 직원 정보를 확인하는 컨트롤러 메서드
     * @return 직원 정보 리스트
     */
    @GetMapping("/employee")
    @ResponseStatus(HttpStatus.OK)
    public List<EmployeeListResponseDto> findAllEmployee() throws EmployeeException {
        return employeeService.findAllEmployee();
    }
}
