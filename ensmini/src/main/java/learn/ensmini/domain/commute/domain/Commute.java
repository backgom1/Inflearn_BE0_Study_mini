package learn.ensmini.domain.commute.domain;


import jakarta.persistence.*;
import learn.ensmini.domain.commute.enums.CommuteStatus;
import learn.ensmini.domain.employee.domain.Employee;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Commute {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "commute_id")
    private Long commuteId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    private Employee employeeCommute;

    @Enumerated(EnumType.ORDINAL)
    private CommuteStatus status;

    @Column(name = "regist_date")
    private LocalDateTime registDate;
}
