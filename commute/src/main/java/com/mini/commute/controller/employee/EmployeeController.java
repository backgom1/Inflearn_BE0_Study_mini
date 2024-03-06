package com.mini.commute.controller.employee;

import com.mini.commute.common.ResponseData;
import com.mini.commute.dto.employee.EmployeeRequest;
import com.mini.commute.service.employee.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/api/v1/employee")
    public ResponseEntity<ResponseData> saveEmployee(@RequestBody EmployeeRequest request) {
        ResponseData responseData = new ResponseData(200, request);
        employeeService.save(request);
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }
}
