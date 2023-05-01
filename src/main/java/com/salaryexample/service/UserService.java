package com.salaryexample.service;
import com.salaryexample.entity.User;

import java.util.List;

public interface UserService {

    double getSalary(Integer id);

    User getUserById(Integer id);

    void save(User user);

    List<User> findAll();

    void deleteUser(Integer id);

    void updateUser(Integer id, User newUser);
}
