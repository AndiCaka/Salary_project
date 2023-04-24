package com.salaryexample.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "work_day")
@Getter
@Setter
@NoArgsConstructor
public class WorkDay {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "day_id")
    private Day day;

    @Column(length = 45, nullable = false, name = "date")
    private LocalDate date;

    @Column(nullable = false, name = "hour")
    private int hour;
}
