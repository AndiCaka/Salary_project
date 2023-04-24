package com.salaryexample.service;

import com.salaryexample.entity.Day;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface DayService {
    void save(Day day);

    List<Day> findDayByUserId(Integer id);
//    Optional<Day> findById(Integer id);

    List<Day> findAll();
}
