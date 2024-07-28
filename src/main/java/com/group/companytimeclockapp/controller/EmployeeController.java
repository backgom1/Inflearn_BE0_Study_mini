package com.group.companytimeclockapp.controller;

import com.group.companytimeclockapp.dto.request.EmployeeSaveRequest;
import com.group.companytimeclockapp.dto.request.EmployeeUpdateTeamRequest;
import com.group.companytimeclockapp.dto.response.EmployeeGetAllResponse;
import com.group.companytimeclockapp.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/employees")
class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<EmployeeGetAllResponse> getAll(){
        return employeeService.getAll();
    }

    @PostMapping
    public void saveEmployee(@RequestBody EmployeeSaveRequest employee) {
        employeeService.saveEmployee(employee);
    }

    @PutMapping()
    public void updateEmployeeTeamName(@RequestBody EmployeeUpdateTeamRequest request) {
        employeeService.updateEmployeeTeam(request.getTeamName(), request.getEmployeeId());
    }

}
