package learn.ensmini.domain.employee.controller;

import learn.ensmini.domain.employee.dto.request.EmployeeCreateRequest;
import learn.ensmini.domain.employee.dto.response.EmployeeCreateResponse;
import learn.ensmini.domain.employee.dto.response.EmployeeListResponseDto;
import learn.ensmini.domain.employee.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping("/employee")
    @ResponseStatus(HttpStatus.OK)
    public EmployeeCreateResponse saveEmployee(@RequestBody EmployeeCreateRequest request) {
       return employeeService.save(request);
    }

    @GetMapping("/employee")
    @ResponseStatus(HttpStatus.OK)
    public List<EmployeeListResponseDto> findAllEmployee(){
        return employeeService.findAllEmployee();
    }
}
