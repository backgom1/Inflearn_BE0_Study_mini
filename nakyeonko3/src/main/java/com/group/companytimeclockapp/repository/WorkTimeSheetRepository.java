package com.group.companytimeclockapp.repository;

import com.group.companytimeclockapp.entity.WorkTimeSheet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WorkTimeSheetRepository extends JpaRepository <WorkTimeSheet, Long> {
    Optional<WorkTimeSheet> findByEmployeeId(long employeeId);
}
