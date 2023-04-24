package com.salaryexample.controller;

import com.salaryexample.entity.Day;
import com.salaryexample.service.DayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/day")
public class DayController {

    @Autowired
    private DayService dayService;

    @GetMapping("/getUserDay/{id}")
    public ResponseEntity<?> findUserById(@PathVariable Integer id){
        return new ResponseEntity<>(dayService.findDayByUserId(id), HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> findAll(){
        return new ResponseEntity<>(dayService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/add")
    public Day save(@RequestBody Day day){
        dayService.save(day);
        return day;
    }
}
