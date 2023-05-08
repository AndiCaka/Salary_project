package com.salaryexample.controller;

import com.salaryexample.entity.User;
import com.salaryexample.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*", maxAge = 3600)
public class UserController {

    @Autowired
    private UserService userService;

    //out for now(Authentication)
//    @GetMapping("/getSalary/{id}")
//    public ResponseEntity<?> getSalary(@PathVariable Integer id) {
//        return new ResponseEntity<>(userService.getSalary(id), HttpStatus.OK);
//    }

    @GetMapping("/getSalary")
    public ResponseEntity<?> getSalary(Authentication authentication) {
        return new ResponseEntity<>(userService.getSalary(authentication), HttpStatus.OK);
    }

    //out for now(Authentication)
//    @GetMapping("/getUserById/{id}")
//    public ResponseEntity<?> getUserById(@PathVariable Long id) {
//        return new ResponseEntity<>(userService.getUserById(id), HttpStatus.OK);
//    }

    @GetMapping("/getAuthenticatedUser")
    public ResponseEntity<?> getAuthenticatedUser(Authentication authentication) {
        return new ResponseEntity<>(userService.getAuthenticatedUser(authentication), HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> findAll(){
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }


    //out for now(Authentication)
//    @PostMapping("/addUser")
//    public User save(@RequestBody User user){
//        userService.save(user);
//        return user;
//    }

    //out for now(Authentication)
//    @DeleteMapping("/deleteUser/{id}")
//    @PreAuthorize("hasRole('ROLE_ADMIN')")
//    public ResponseEntity<Void> deleteUserById(@PathVariable("id") Integer id) {
//        userService.deleteUser(id);
//        return ResponseEntity.noContent().build();
//    }

    //out for now(Authentication)
//    @PutMapping("/updateUser/{userId}")
//    @PreAuthorize("hasRole('ROLE_ADMIN')")
//    public ResponseEntity<User> updateUser(@PathVariable("userId") Long userId, @RequestBody User user) {
//        userService.updateUser(userId, user);
//        return ResponseEntity.ok(user);
//    }
}
