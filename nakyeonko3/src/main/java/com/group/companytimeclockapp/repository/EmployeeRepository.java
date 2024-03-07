package com.group.companytimeclockapp.repository;

import com.group.companytimeclockapp.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
