package com.salaryexample.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "day")
@Getter
@Setter
@NoArgsConstructor
public class Day {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private User user;

    @Column(length = 45, nullable = false, name = "date")
    private LocalDate date;

    @Column(nullable = false, name = "hour")
    private int hour;

}
