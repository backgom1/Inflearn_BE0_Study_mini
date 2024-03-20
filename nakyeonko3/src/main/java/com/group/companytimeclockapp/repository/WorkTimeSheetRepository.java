package com.group.companytimeclockapp.repository;

import com.group.companytimeclockapp.entity.WorkTimeSheet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WorkTimeSheetRepository extends JpaRepository <WorkTimeSheet, Long> {

    @Query(value = "select id, clock_in_time, clock_out_time, work_time_sheet.employee_id from work_time_sheet where employee_id = 1 ORDER BY id DESC LIMIT 1" ,nativeQuery = true)
    Optional<WorkTimeSheet> findByIdActiveEmployeeId(long employeeId);

}
