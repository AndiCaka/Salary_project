package com.salaryexample.service;


import com.salaryexample.entity.User1;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface UserService1 {

    double getSalary(Integer id);
    Optional<User1> getUserById(Integer id);

    void save(User1 user);

    List<User1> findAll();

}
