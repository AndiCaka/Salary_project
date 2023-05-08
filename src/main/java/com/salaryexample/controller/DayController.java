package com.salaryexample.controller;

import com.salaryexample.entity.Day;
import com.salaryexample.entity.User;
import com.salaryexample.repository.DayRepository;
import com.salaryexample.repository.UserRepository;
import com.salaryexample.service.DayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import java.lang.reflect.InvocationTargetException;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/day")
public class DayController {

    @Autowired
    private DayService dayService;

    @Autowired
    private DayRepository dayRepository;

    @Autowired
    private UserRepository userRepository;


    @GetMapping("/getDaysByUserId")
    public List<Day> getDaysByAuthenticatedUser(Authentication authentication) throws InvocationTargetException {
        return dayService.findDaysByAuthenticatedUser(authentication);
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> findAll(){
        return new ResponseEntity<>(dayService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/addDay")
    public ResponseEntity<Day> createDay(Authentication authentication, @RequestBody Day day) {
        return ResponseEntity.ok(dayService.createDay(authentication, day));
    }

    @DeleteMapping("/deleteDay/{id}")
    public ResponseEntity<Void> deleteDayById(@PathVariable Integer id) {
        dayService.deleteDay(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/updateDay/{id}")
    public ResponseEntity<Day> updateDay(@PathVariable Integer id, @RequestBody Day newDay) {
        dayService.updateDay(id, newDay);
        return ResponseEntity.ok(newDay);
    }
}
