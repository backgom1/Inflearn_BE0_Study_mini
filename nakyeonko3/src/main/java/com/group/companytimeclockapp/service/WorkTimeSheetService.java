package com.group.companytimeclockapp.service;

import com.group.companytimeclockapp.entity.WorkTimeSheet;
import com.group.companytimeclockapp.repository.WorkTimeSheetRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalTime;

@Service
public class WorkTimeSheetService {

    private final WorkTimeSheetRepository workTimeSheetRepository;

    public WorkTimeSheetService(WorkTimeSheetRepository workTimeSheetRepository) {
        this.workTimeSheetRepository = workTimeSheetRepository;
    }

    @Transactional
    public void clockIn(long id) {
        workTimeSheetRepository.save(WorkTimeSheet.builder()
                .employeeId(id)
                .clockInTime(LocalTime.now())
                .build());
    }

    @Transactional
    public void clockOut(long id) {
        WorkTimeSheet workTimeSheet = workTimeSheetRepository.findByEmployeeId(id)
                .orElseThrow(IllegalAccessError::new);
        workTimeSheet.updateClockOutTime();
    }
}
