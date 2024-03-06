package learn.ensmini.domain.employee.repository;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import learn.ensmini.domain.employee.dto.response.EmployeeListResponseDto;
import learn.ensmini.domain.team.domain.QTeam;
import org.springframework.stereotype.Repository;

import java.util.List;

import static learn.ensmini.domain.employee.domain.QEmployee.employee;
import static learn.ensmini.domain.team.domain.QTeam.*;

@Repository
public class EmployeeQueryDSLRepository {
    JPAQueryFactory queryFactory;

    @PersistenceContext
    private EntityManager em;

    public List<EmployeeListResponseDto> findAll() {
        queryFactory = new JPAQueryFactory(em);
        return queryFactory.select(Projections.constructor(
                        EmployeeListResponseDto.class,
                        employee.name,
                        employee.teamEmployee.name.as("teamName"),
                        employee.role,
                        employee.birthday,
                        employee.workStartDate
                ))
                .from(employee)
                .join(employee.teamEmployee, team)
                .fetch();
    }
}
