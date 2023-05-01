package com.salaryexample.controller;

import com.salaryexample.entity.User;
import com.salaryexample.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getSalary/{id}")
    public ResponseEntity<?> getSalary(@PathVariable Integer id) {
        return new ResponseEntity<>(userService.getSalary(id), HttpStatus.OK);
    }

    @GetMapping("/getUserById/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Integer id) {
        return new ResponseEntity<>(userService.getUserById(id), HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> findAll(){
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/addUser")
    public User save(@RequestBody User user){
        userService.save(user);
        return user;
    }

    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/updateUser/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Integer id, @RequestBody User newUser) {
        userService.updateUser(id, newUser);
        return ResponseEntity.ok(newUser);
    }
}
