package com.salaryexample.repository;

import java.util.Optional;

import com.salaryexample.entity.ERole;
import com.salaryexample.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}