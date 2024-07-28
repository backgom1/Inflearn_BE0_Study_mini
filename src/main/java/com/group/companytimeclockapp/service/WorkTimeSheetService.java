package com.group.companytimeclockapp.service;

import com.group.companytimeclockapp.entity.Employee;
import com.group.companytimeclockapp.entity.WorkStatus;
import com.group.companytimeclockapp.entity.WorkTimeSheet;
import com.group.companytimeclockapp.repository.EmployeeRepository;
import com.group.companytimeclockapp.repository.WorkTimeSheetRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalTime;

@Service
public class WorkTimeSheetService {

    private final WorkTimeSheetRepository workTimeSheetRepository;

    private final EmployeeRepository employeeRepository;

    public WorkTimeSheetService(WorkTimeSheetRepository workTimeSheetRepository, EmployeeRepository employeeRepository) {
        this.workTimeSheetRepository = workTimeSheetRepository;
        this.employeeRepository = employeeRepository;
    }

    @Transactional
    public void clockIn(long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(IllegalAccessError::new);

        validateClockIn(employee);

        workTimeSheetRepository.save(WorkTimeSheet.builder()
                .employeeId(id)
                .clockInTime(LocalTime.now())
                .build());

        employee.updateWorkStatus(WorkStatus.CLOCK_IN);
  }

    @Transactional
    public void clockOut(long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(IllegalAccessError::new);

        validateClockOut(employee);

        WorkTimeSheet workTimeSheet = workTimeSheetRepository.findByIdActiveEmployeeId(id)
                .orElseThrow(IllegalAccessError::new);
        workTimeSheet.updateClockOutTime();

        employee.updateWorkStatus(WorkStatus.CLOCK_OUT);
    }

    private void validateClockIn(Employee employee) {
        if(WorkStatus.CLOCK_IN.equals(employee.getWorkStatus())) {
            throw new IllegalArgumentException();
        }
    }

    private void validateClockOut(Employee employee) {
        if(!WorkStatus.CLOCK_IN.equals(employee.getWorkStatus())) {
            throw new IllegalArgumentException();
        }
    }
}
