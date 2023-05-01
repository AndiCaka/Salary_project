package com.salaryexample.service;
import com.salaryexample.entity.Day;

import java.util.List;

public interface DayService {
    void save(Day day);

    List<Day> findDaysByUserId(Integer id);

    List<Day> findAll();

    void deleteDay(Integer id);

    void updateDay(Integer id, Day newDay);
}
