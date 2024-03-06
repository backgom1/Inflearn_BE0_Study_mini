package com.group.companytimeclockapp.repository;

import com.group.companytimeclockapp.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
