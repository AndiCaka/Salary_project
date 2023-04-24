package com.salaryexample.service;

import com.salaryexample.entity.Day;
import com.salaryexample.repository.DayRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DayServiceImpl implements DayService{

    @Autowired
    DayRepository dayRepository;


    @Override
    public void save(Day day) {
        dayRepository.save(day);
    }

    @Override
    public List<Day> findDayByUserId(Integer id) {
        return dayRepository.findDayByUserId(id);
    }

    @Override
    public List<Day> findAll() {
        return dayRepository.findAll();
    }
}
