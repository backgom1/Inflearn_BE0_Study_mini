package com.group.companytimeclockapp.repository;

import com.group.companytimeclockapp.entity.WorkTimeSheet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WorkTimeSheetRepository extends JpaRepository <WorkTimeSheet, Long> {

    @Query(value = "select w from WorkTimeSheet w where w.employeeId = 1 ORDER BY w.id DESC LIMIT 1")
    Optional<WorkTimeSheet> findByIdActiveEmployeeId(long employeeId);

}
