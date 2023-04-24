package com.salaryexample.repository;

import com.salaryexample.entity.Day;
import com.salaryexample.entity.User1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DayRepository  extends JpaRepository<Day, Integer> {

    @Query(value = "select d from Day d where d.users_id = ?1")
    public List<Day> workList(Integer id);

    @Query(value = "select d from Day d where d.users_id = ?1")
    List<Day> findDayByUserId(Integer id);
}
