package com.partha.appointment.repository;

import com.partha.appointment.entities.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * User: Partha Pratim Baral
 * Date: 5/17/2023
 */

@Repository
public interface StatusRepository extends JpaRepository<Status, Long> {

}
