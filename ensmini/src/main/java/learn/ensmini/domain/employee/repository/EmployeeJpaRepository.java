package learn.ensmini.domain.employee.repository;

import learn.ensmini.domain.employee.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeJpaRepository extends JpaRepository<Employee,Long> {
}
