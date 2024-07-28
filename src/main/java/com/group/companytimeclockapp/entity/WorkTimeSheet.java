package com.group.companytimeclockapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalTime;

@Entity
@Getter
@Builder
@AllArgsConstructor
public class WorkTimeSheet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private LocalTime clockInTime;

    @Column
    private LocalTime clockOutTime;

    @Column(nullable = false)
    private long employeeId;

    protected WorkTimeSheet() {
    }

    public void updateClockOutTime() {
        this.clockOutTime = LocalTime.now();
    }
}
