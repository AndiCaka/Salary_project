package com.salaryexample.service;
import com.salaryexample.entity.Day;
import com.salaryexample.entity.User;
import com.salaryexample.repository.DayRepository;
import com.salaryexample.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Autowired
    DayRepository dayRepository;

    @Override
    public double getSalary(Integer id) {

        double hour_amount = userRepository.findUserById(id).getSalary()/176;

        int hour_out = 0;
        int hour_in = 0;
        double total_amount = 0;

        for(Day day: dayRepository.workList(id)){
            int hour = day.getHour();

            if (isReligionHoliday(day.getDate())){
                if (hour > 8) {
                    hour_out = hour - 8;
                    hour_in = 8;
                } else {
                    hour_out = 0;
                    hour_in = hour;
                }
                total_amount = (hour_in*hour_amount*1.5)+(hour_out*hour_amount*2);
            } else if (isWeekend(day.getDate())) {
                if (hour > 8) {
                    hour_out = hour - 8;
                    hour_in = 8;
                } else {
                    hour_out = 0;
                    hour_in = hour;
                }
                total_amount = (hour_in*hour_amount*1.25)+(hour_out*hour_amount*1.5);
            } else{
                if (hour>8){
                    hour_out = hour-8;
                    hour_in=8;
                }else {
                    hour_out=0;
                    hour_in=hour;
                }
                total_amount = total_amount + (hour_in*hour_amount*1)+(hour_out*hour_amount*1.25);
            }
        }

        return total_amount;
    }

    public boolean isWeekend(LocalDate date) {
        return date.getDayOfWeek() == DayOfWeek.SATURDAY || date.getDayOfWeek() == DayOfWeek.SUNDAY;
    }

    public boolean isReligionHoliday(LocalDate date) {
        List<LocalDate> religionHoliday = new ArrayList<>();
        religionHoliday.add(LocalDate.parse("2023-01-01"));
        religionHoliday.add(LocalDate.parse("2023-01-02"));
        religionHoliday.add(LocalDate.parse("2023-03-14"));
        religionHoliday.add(LocalDate.parse("2023-03-22"));
        religionHoliday.add(LocalDate.parse("2023-04-09"));
        religionHoliday.add(LocalDate.parse("2023-04-16"));
        religionHoliday.add(LocalDate.parse("2023-04-21"));
        religionHoliday.add(LocalDate.parse("2023-05-01"));
        religionHoliday.add(LocalDate.parse("2023-06-28"));
        religionHoliday.add(LocalDate.parse("2023-09-05"));
        religionHoliday.add(LocalDate.parse("2023-11-28"));
        religionHoliday.add(LocalDate.parse("2023-11-29"));
        religionHoliday.add(LocalDate.parse("2023-12-08"));
        religionHoliday.add(LocalDate.parse("2023-12-25"));

        for (LocalDate d:religionHoliday){
            if (date.isEqual(d)){
                return true;
            }
        }
        return false;
    }

    @Override
    public User getUserById(Integer id) {
        return userRepository.findUserById(id);
    }

    @Override
    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }

    @Override
    public void updateUser(Integer id, User newUser) {
        User user = userRepository.findById(id).orElseThrow(() -> new NotFoundException("User with id "+ id +" not found."));
        user.setFirstName(newUser.getFirstName());
        user.setLastName(newUser.getLastName());
        user.setSalary(newUser.getSalary());
        userRepository.save(user);
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

}
