package com.group.companytimeclockapp.domain;

import com.group.companytimeclockapp.util.Role;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Entity
@Getter
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    @OneToMany(mappedBy = "team")
    private List<Employee> employees;

    protected Team() {
    }

    public Team(String name) {
        this.name = name;
    }

    public List<String> getManagerName() {
        return this.getEmployees()
                .stream()
                .filter(employee -> employee.getRole()
                        .equals(Role.MANAGER))
                .map(Employee::getName)
                .collect(Collectors.toList());
    }

    public void addEmployee(Employee employee) {
        employee.updateTeamName(this);
        employees.add(new Employee(employee.getName(), employee.getRole(), employee.getBirthday(), employee.getWorkStartDate()));
    }
}
