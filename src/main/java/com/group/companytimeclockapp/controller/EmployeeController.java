package com.group.companytimeclockapp.controller;

import com.group.companytimeclockapp.dto.request.EmployeeSaveRequest;
import com.group.companytimeclockapp.dto.request.EmployeeUpdateTeamRequest;
import com.group.companytimeclockapp.service.EmployeeService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("employee")
class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("hello")
    public String testSomething(@RequestParam String name) {
        return "Hello, " + name;
    }

    @PostMapping
    public void saveEmployee(@RequestBody EmployeeSaveRequest employee) {
        employeeService.saveEmployee(employee);
    }

    @PutMapping("enrollTeam")
    public void updateEmployeeTeamName(@RequestBody EmployeeUpdateTeamRequest request) {
        employeeService.updateEmployeeTeam(request.getTeamName(), request.getEmployeeId());
    }

}
