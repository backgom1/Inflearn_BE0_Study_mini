package learn.ensmini.domain.commute.repository;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import learn.ensmini.domain.commute.domain.Commute;
import learn.ensmini.domain.commute.dto.MinuteList;
import learn.ensmini.domain.commute.enums.CommuteStatus;
import learn.ensmini.domain.employee.domain.Employee;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static com.querydsl.core.types.dsl.Expressions.*;
import static learn.ensmini.domain.commute.domain.QCommute.commute;

@Repository
public class CommuteQueryDSLRepository {

    JPAQueryFactory queryFactory;

    @PersistenceContext
    private EntityManager em;

    /**
     * 직원이 출근을 진행했는지에 대한 구하는 쿼리입니다.
     *
     * @param employee   직원
     * @param targetDate 선택된 날짜
     * @return 출근한 직원에 대한 존재여부 반환
     */
    public List<Commute> existTodayCommuteByEmployee(Employee employee, LocalDateTime targetDate) {
        queryFactory = new JPAQueryFactory(em);

        return queryFactory.select(commute)
                .from(commute)
                .where(commute.employeeCommute.employeeId.eq(employee.getEmployeeId())
                        .and(dateTemplate(LocalDate.class, "DATE_FORMAT({0},'%Y-%M-%D')", commute.registDate)
                                .eq(dateTemplate(LocalDate.class, "DATE_FORMAT({0},'%Y-%M-%D')", targetDate)))
                        .and(commute.status.eq(CommuteStatus.CHECKIN)))
                .fetch();
    }

    /**
     * 직원이 출,퇴근한 기록에 대한 해당 날짜와 일한 시간 출력 쿼리
     *
     * @return
     */
    public List<MinuteList> calculateWorkMinute(Long id) {

        queryFactory = new JPAQueryFactory(em);
        return queryFactory.select(Projections.fields(MinuteList.class,
                        dateTemplate(String.class, "DATE_FORMAT({0},'%Y-%m-%d')", commute.registDate).as("date"),
                        numberTemplate(Integer.class, "{0}-{1}",
                                commute.status.when(CommuteStatus.CHECKOUT)
                                        .then(numberTemplate(Integer.class, "{0} + {1}",
                                                numberTemplate(Integer.class, "{0} * {1}", dateTemplate(LocalDateTime.class, "HOUR({0})", commute.registDate), 60)
                                                , numberTemplate(Integer.class, "{0}", dateTemplate(LocalDateTime.class, "MINUTE({0})", commute.registDate)))).otherwise(0).sum(),
                                commute.status.when(CommuteStatus.CHECKIN)
                                        .then(numberTemplate(Integer.class, "{0} + {1}",
                                        numberTemplate(Integer.class, "{0} * {1}",
                                                dateTemplate(LocalDateTime.class, "HOUR({0})", commute.registDate), 60),
                                        numberTemplate(Integer.class,"{0}",dateTemplate(LocalDateTime.class, "MINUTE({0})", commute.registDate)))).otherwise(0).sum()).as("workingMinutes")))
                .from(commute)
                .where(commute.employeeCommute.employeeId.eq(id))
                .groupBy(dateTemplate(LocalDate.class, "DATE_FORMAT({0},'%Y-%m-%d')", commute.registDate))
                .fetch();
    }
}
