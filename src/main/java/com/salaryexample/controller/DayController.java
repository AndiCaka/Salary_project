package com.salaryexample.controller;

import com.salaryexample.entity.Day;
import com.salaryexample.service.DayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/day")
public class DayController {

    @Autowired
    private DayService dayService;

    @GetMapping("/getDaysByUserId/{id}")
    public ResponseEntity<?> findUserById(@PathVariable Integer id){
        return new ResponseEntity<>(dayService.findDaysByUserId(id), HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> findAll(){
        return new ResponseEntity<>(dayService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/addDay")
    public Day save(@RequestBody Day day){
        dayService.save(day);
        return day;
    }

    @DeleteMapping("/deleteDay/{id}")
    public ResponseEntity<Void> deleteDay(@PathVariable Integer id) {
        dayService.deleteDay(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/updateDay/{id}")
    public ResponseEntity<Day> updateDay(@PathVariable Integer id, @RequestBody Day newDay) {
        dayService.updateDay(id, newDay);
        return ResponseEntity.ok(newDay);
    }
}
