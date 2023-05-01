package com.salaryexample.service;

import com.salaryexample.entity.Day;
import com.salaryexample.repository.DayRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;

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
    public List<Day> findDaysByUserId(Integer id) {
        return dayRepository.findDaysByUserId(id);
    }

    @Override
    public List<Day> findAll() {
        return dayRepository.findAll();
    }

    @Override
    public void deleteDay(Integer id) {
        dayRepository.deleteById(id);
    }

    @Override
    public void updateDay(Integer id, Day newDay) {
        Day day = dayRepository.findById(id).orElseThrow(() -> new NotFoundException("Day with id "+ id +" not found."));
        day.setDate(newDay.getDate());
        day.setHour(newDay.getHour());
        dayRepository.save(day);
    }
}
