package com.partha.appointment.dao;

import com.partha.appointment.entities.Appointment;
import com.partha.appointment.utility.QueryOperands;

import java.util.List;

/**
 * User: Partha Pratim Baral
 * Date: 5/18/2023
 */

public interface AppointmentDao {

    public Appointment saveAppointment(Appointment appointment);
    public List<Appointment> getAllAppointment(List<String> queryParam, List<Object> queryValue,
                                               List<QueryOperands> operands);
    public Appointment findById(Integer appointmentId);
    public void delete(Appointment appointment);
    public Appointment update(Appointment appointment);
}
