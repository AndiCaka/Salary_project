package com.salaryexample.repository;

import com.salaryexample.entity.OffDay;
import com.salaryexample.entity.User1;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OffDayRepository  extends JpaRepository<OffDay, Long> {
}
