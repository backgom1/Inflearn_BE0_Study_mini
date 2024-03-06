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
        validate(name);
        this.name = name;
        this.role = role;
        this.birthday = birthday;
        this.workStartDate = workStartDate;
    }

    public Employee(EmployeeSaveRequest request) {
        this(request.getName(), request.getRole(), request.getBirthday(), request.getWorkStartDate());
    }

    // TODO: 문자열 유효성 검사 util클래스로 따로 뺴기
    public void validate(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException(String.format("잘못된 name(%s)이 들어 왔습니다.", name));
        }
    }


    public void updateTeamName(Team team) {
        this.team = team;
    }


}
