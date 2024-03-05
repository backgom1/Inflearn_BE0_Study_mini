package learn.ensmini.domain.team.domain;


import jakarta.persistence.*;
import learn.ensmini.domain.annual.domain.Annual;
import learn.ensmini.domain.employee.domain.Employee;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * 팀에 대한 도메인 객체
 *
 * @author dmstjd
 * @version v0.0.1
 * @since 2024-03-05
 */
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Team {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "team_id")
    private Long teamId;

    @Column(length = 45)
    private String name;

    @Column(length = 45)
    private String manager;

    @Column(name = "member_count")
    private int memberCount;

    @Column(name = "annual_role")
    private int annualRole;

    @OneToMany(mappedBy = "teamEmployee")
    private List<Employee> employeeTeam = new ArrayList<>();

    @OneToMany(mappedBy = "teamAnnual")
    private List<Annual> employeeAnnual = new ArrayList<>();

    @Builder
    private Team(String name, String manager, int memberCount, int annualRole) {
        this.name = name;
        this.manager = manager;
        this.memberCount = memberCount;
        this.annualRole = annualRole;
    }
}
