package learn.ensmini.domain.annual.domain;


import jakarta.persistence.*;
import learn.ensmini.domain.employee.domain.Employee;
import learn.ensmini.domain.team.domain.Team;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Annual {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "annual_id")
    private Long annualId;

    @ManyToOne
    @JoinColumn(name = "employ_id")
    private Employee employeeAnnual;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team teamAnnual;

    @Column(name = "regist_date")
    private LocalDateTime registDate;
}
