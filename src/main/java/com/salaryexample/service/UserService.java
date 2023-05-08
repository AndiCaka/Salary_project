package com.salaryexample.service;
import com.salaryexample.entity.User;
import org.springframework.security.core.Authentication;

import java.util.List;

public interface UserService {

    double getSalary(Authentication authentication);

//    User getUserById(Long id);

    User getAuthenticatedUser(Authentication authentication);

//    void save(User user);

    List<User> findAll();

//    void deleteUser(Integer id);

//    User updateUser(Long id, User user);
}
