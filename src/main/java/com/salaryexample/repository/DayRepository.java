package com.salaryexample.repository;

import com.salaryexample.entity.Day;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DayRepository  extends JpaRepository<Day, Integer> {

    @Query(value = "select d from Day d where d.user.id = ?1")
    List<Day> workList(Integer id);

    @Query(value = "select d from Day d where d.user.id = ?1")
    List<Day> findDaysByUserId(Integer id);
}
