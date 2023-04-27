package com.salaryexample.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
public class User1 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 45, nullable = false, name = "first_name")
    private String firstName;

    @Column(length = 45, nullable = false, name = "last_name")
    private String lastName;

    @Column(nullable = false, name = "salary")
    private int salary;

    @OneToMany(mappedBy = "user1")
    public List<Day> days;


//    @OneToMany(targetEntity = OffDay.class, cascade = CascadeType.ALL)
//    @JoinColumn(name = "users_id", referencedColumnName = "id")
//    private List<OffDay> offDayList;
//
//    @OneToMany(targetEntity = WorkDay.class, cascade = CascadeType.ALL)
//    @JoinColumn(name = "users_id", referencedColumnName = "id")
//    private List<WorkDay> workDayList;
//
//    @OneToMany(targetEntity = Holiday.class, cascade = CascadeType.ALL)
//    @JoinColumn(name = "users_id", referencedColumnName = "id")
//    private List<Holiday> holidayList;
}