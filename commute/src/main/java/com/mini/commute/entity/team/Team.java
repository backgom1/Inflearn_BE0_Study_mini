package com.mini.commute.entity.team;

import com.mini.commute.entity.employee.Employee;
import com.mini.commute.entity.employee.Role;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TEAM_ID")
    private Long id;

    private String name;
//    private String manager; // 넣어야 하나? 아님 employeeId로 처리?

    /*
     필드 레벨에서 컬렌션은 초기화하는 것이 좋음
     NPE 방지
     */
    @OneToMany(mappedBy = "team")
    private List<Employee> employees = new ArrayList<Employee>();

    public Team(String name) {
        this.name = name;
    }

    public String pickManager() {
        String manager = "";
        for(Employee e : employees) {
            if(e.getRole().equals(Role.MANAGER)) {
                manager = e.getName();
            }
        }
        return manager;
    }
}
