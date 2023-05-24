package com.partha.appointment.repository;

import com.partha.appointment.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * User: Partha Pratim Baral
 * Date: 5/18/2023
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUserId(Integer userId);
    User findByUsername(String username);
}
