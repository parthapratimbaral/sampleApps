package com.partha.appointment.repository;

import com.partha.appointment.entities.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * User: Partha Pratim Baral
 * Topic :
 * Date: 5/17/2023
 */

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {

    public <S extends Appointment> S save(S entity);
    public List<Appointment> find(String queryName, String queryParam, Object queryValue, String operands);
    public void deleteById(String queryName, String queryParam, Object queryValue, String operands);

    public Optional<Appointment> findById(Integer appointmentId);

    public <S extends Appointment> S saveAndFlush(S entity);

    List<Appointment> findByUserSearchAndSorted(String type, List<String> queryParam, List<Object> queryValue);
}

