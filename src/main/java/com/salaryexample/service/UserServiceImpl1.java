package com.salaryexample.service;


import com.salaryexample.entity.Day;
import com.salaryexample.entity.User1;
import com.salaryexample.repository.UserRepository1;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl1 implements UserService1{

    @Autowired
    UserRepository1 userRepository1;

    @Override
    public double getSalary(Integer id) {

        double hour_amount = userRepository1.findUserById(id).get().getSalary()/176;
        double amount = userRepository1.findUserById(id).get().getSalary();

        System.out.println("amount  ->  "+ amount);
        System.out.println("hour_amount  ->  "+ hour_amount);

        int hour_out = 0;
        int hour_in = 0;
        double total_amount = 0;

        for(Day day: userRepository1.workList(id)){
            int hour = day.getHour();

            if (isWeekend(day.getDate())) {
                if (hour > 8) {
                    hour_out = hour - 8;
                    hour_in = 8;
                } else {
                    hour_out = 0;
                    hour_in = hour;
                }
                total_amount = (hour_in*hour_amount*1.5)+(hour_out*hour_amount*2);
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

        System.out.println("hour_in  ->  "+ hour_in);
        System.out.println("hour_out  ->  "+ hour_out);
        System.out.println("total_amount  ->  "+ total_amount);

        return total_amount;
    }

    public boolean isWeekend(LocalDate date) {
        return date.getDayOfWeek() == DayOfWeek.SATURDAY || date.getDayOfWeek() == DayOfWeek.SUNDAY;
    }

    @Override
    public Optional<User1> getUserById(Integer id) {
        return userRepository1.findUserById(id);
    }

    @Override
    public void save(User1 user) {
        userRepository1.save(user);
    }

    @Override
    public List<User1> findAll() {
        return userRepository1.findAll();
    }

}
