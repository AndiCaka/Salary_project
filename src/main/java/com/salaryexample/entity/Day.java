package com.salaryexample.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "day")
@Getter
@Setter
@NoArgsConstructor
public class Day {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

//    @Column(length = 45, nullable = false, name = "users_id")
//    private int users_id;

    @ManyToOne
    private User1 user1;

    @Column(length = 45, nullable = false, name = "date")
    private LocalDate date;

    @Column(nullable = false, name = "hour")
    private int hour;

//    @OneToMany(targetEntity = OffDay.class, cascade = CascadeType.ALL)
//    @JoinColumn(name = "day_id", referencedColumnName = "id")
//    private List<OffDay> offDayList;
//
//    @OneToMany(targetEntity = WorkDay.class, cascade = CascadeType.ALL)
//    @JoinColumn(name = "day_id", referencedColumnName = "id")
//    private List<WorkDay> workDayList;
//
//    @OneToMany(targetEntity = Holiday.class, cascade = CascadeType.ALL)
//    @JoinColumn(name = "day_id", referencedColumnName = "id")
//    private List<Holiday> holidayList;
}
