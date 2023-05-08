package com.salaryexample.service;
import com.salaryexample.entity.Day;
import com.salaryexample.entity.User;
import org.springframework.security.core.Authentication;

import java.time.LocalDate;
import java.util.List;

public interface DayService {

    List<Day> findAll();

    void deleteDay(Integer id);

    void updateDay(Integer id, Day newDay);

    Day createDay(Authentication authentication, Day day);

    List<Day> findDaysByAuthenticatedUser(Authentication authentication);

}
