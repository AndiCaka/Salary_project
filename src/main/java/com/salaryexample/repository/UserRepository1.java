package com.salaryexample.repository;

import com.salaryexample.entity.Day;
import com.salaryexample.entity.User1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository1 extends JpaRepository<User1, Integer> {

    Optional<User1> findUserById(Integer id);

    @Query(value = "select d from Day d where d.users_id = ?1")
    List<Day> workList(Integer id);

}
