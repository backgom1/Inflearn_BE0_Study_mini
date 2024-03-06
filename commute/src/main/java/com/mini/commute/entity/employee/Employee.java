package com.mini.commute.entity.employee;

import com.mini.commute.entity.team.Team;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Getter
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MEMBER_ID")
    private Long id;

    private String name;
    private LocalDate birthday;
    private LocalDate workStartDate;
    private Role role;
    private boolean isNewbie;

    @ManyToOne
    @JoinColumn(name = "TEAM_ID")
    private Team team;

    public Employee(String name, LocalDate birthday, LocalDate workStartDate, Role role) {
        this.name = name;
        this.birthday = birthday;
        this.workStartDate = workStartDate;
        this.role = role;
        calculateIsNewbie();
    }

    public void calculateIsNewbie() {
        LocalDate targetDate = LocalDate.of(2024, 1, 1);
        this.isNewbie = !workStartDate.isBefore(targetDate);
    }

    /* 연관관계 메소드 */
    public void setTeam(Team team) {
        this.team = team;
        team.getEmployees().add(this);
    }
}
