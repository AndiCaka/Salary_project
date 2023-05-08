package com.salaryexample.service;

import com.salaryexample.entity.Day;
import com.salaryexample.entity.User;
import com.salaryexample.repository.DayRepository;
import com.salaryexample.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DayServiceImpl implements DayService{

    @Autowired
    DayRepository dayRepository;

    @Autowired
    private UserRepository userRepository;

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

    @Override
    public Day createDay(Authentication authentication, Day day) {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        Optional<User> user = userRepository.findByUsername(userDetails.getUsername());

        day.setUser(user.get());
        Day savedDay = dayRepository.save(day);
        return savedDay;
    }

    @Override
    public List<Day> findDaysByAuthenticatedUser(Authentication authentication) {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        Optional<User> user = userRepository.findByUsername(userDetails.getUsername());
        return user.get().days;
    }

}
