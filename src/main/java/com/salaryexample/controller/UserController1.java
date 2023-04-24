package com.salaryexample.controller;

import com.salaryexample.entity.User1;
import com.salaryexample.service.UserService1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController1 {

    @Autowired
    private UserService1 service;

    @GetMapping("/getSalary/{id}")
    public ResponseEntity<?> getSalary(@PathVariable Integer id) {
        return new ResponseEntity<>(service.getSalary(id), HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> findAll(){
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @PostMapping("/add")
    public User1 save(@RequestBody User1 user){
        service.save(user);
        return user;
    }
}
