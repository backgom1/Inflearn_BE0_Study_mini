package learn.ensmini.domain.employee.domain;

import jakarta.persistence.*;
import learn.ensmini.domain.annual.domain.Annual;
import learn.ensmini.domain.commute.domain.Commute;
import learn.ensmini.domain.team.domain.Team;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


/**
 * 직원에 대한 도메인 객체
 *
 * @author dmstjd
 * @version v0.0.1
 * @since 2024-03-05
 */
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Long employeeId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    private Team teamEmployee;

    @Column(length = 45)
    private String name;

    @Column(length = 45)
    private String role;


    private LocalDate birthday;

    @Column(name = "work_start_date")
    private LocalDate workStartDate;


    @OneToMany(mappedBy = "employeeCommute", fetch = FetchType.LAZY)
    private List<Commute> employeeCommute = new ArrayList<>();

    @OneToMany(mappedBy = "employeeAnnual", fetch = FetchType.LAZY)
    private List<Annual> employeeAnnual = new ArrayList<>();

    @Builder
    private Employee(Team teamEmployee, String name, String role, LocalDate birthday, LocalDate workStartDate) {
        this.teamEmployee = teamEmployee;
        this.name = name;
        this.role = role;
        this.birthday = birthday;
        this.workStartDate = workStartDate;
    }
}
