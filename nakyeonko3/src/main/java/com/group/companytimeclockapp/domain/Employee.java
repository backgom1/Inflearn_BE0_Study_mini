package com.group.companytimeclockapp.domain;

import com.group.companytimeclockapp.dto.request.EmployeeSaveRequest;
import com.group.companytimeclockapp.util.Role;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDate;


@Getter
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Role role;
    @Column(nullable = false)
    private LocalDate birthday;

    @Column(nullable = false)
    private LocalDate workStartDate;

    @ManyToOne
    private Team team;

    protected Employee() {
    }


    public Employee(String name, Role role, LocalDate birthday, LocalDate workStartDate) {
        this.name = name;
        this.role = role;
        this.birthday = birthday;
        this.workStartDate = workStartDate;
    }

    public Employee(EmployeeSaveRequest request) {
        this(request.getName(), request.getRole(), request.getBirthday(), request.getWorkStartDate());
    }


    public void updateTeamName(Team team) {
        this.team = team;
    }


}
