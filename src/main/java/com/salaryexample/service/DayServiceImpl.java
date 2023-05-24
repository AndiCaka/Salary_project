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
    private EmailSenderService emailSenderService;

    @Autowired
    DayRepository dayRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Day> findAll() {
        return dayRepository.findAll();
    }

    @Override
    public void deleteDay(Authentication authentication, Integer id) {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        Optional<User> user = userRepository.findByUsername(userDetails.getUsername());
        Day day = dayRepository.findById(id).orElseThrow(() -> new NotFoundException("Day with id "+ id +" not found."));

        String message  = "Hi "+user.get().getName()+", you just deleted a day!"
                +"\nThe day you deleted was: "
                +"\nhours: "+ day.getHour()
                +"\ndate: "+ day.getDate()
                +"\n";

        dayRepository.deleteById(id);

        this.emailSenderService.sendEmail(user.get().getEmail(), "Delete day", message);

    }

    @Override
    public void updateDay(Authentication authentication, Integer id, Day newDay) {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        Optional<User> user = userRepository.findByUsername(userDetails.getUsername());
        Day day = dayRepository.findById(id).orElseThrow(() -> new NotFoundException("Day with id "+ id +" not found."));

        String message  = "Hi "+user.get().getName()+", you just update a day!"
                +"\nThe old day was: "
                +"\nhours: "+ day.getHour()
                +"\ndate: "+ day.getDate()
                +"\n";

        day.setDate(newDay.getDate());
        day.setHour(newDay.getHour());
        dayRepository.save(day);

        message = message
                +"\nThe new day is: "
                +"\nhours: "+ day.getHour()
                +"\ndate: "+ day.getDate()
                +"\n";

        this.emailSenderService.sendEmail(user.get().getEmail(), "Update day", message);

    }

    @Override
    public Day createDay(Authentication authentication, Day day) {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        Optional<User> user = userRepository.findByUsername(userDetails.getUsername());

        day.setUser(user.get());
        Day savedDay = dayRepository.save(day);

        this.emailSenderService.sendEmail(user.get().getEmail(), "Add day", "Hi "+user.get().getName()+", you just add a day!" +
                "\nYou worked "+ day.getHour() + " hours on " + day.getDate());

        return savedDay;
    }

    @Override
    public List<Day> findDaysByAuthenticatedUser(Authentication authentication) {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        Optional<User> user = userRepository.findByUsername(userDetails.getUsername());
        return user.get().days;
    }

}
