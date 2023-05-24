package com.partha.appointment.service;

import com.partha.appointment.dto.AppointmentRequest;
import com.partha.appointment.dto.AppointmentResponse;
import com.partha.appointment.utility.QueryOperands;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * User: Partha Pratim Baral
 * Topic :
 * Date: 5/18/2023
 */
@Service
public interface AppointmentService {

    public AppointmentResponse saveAppointmentData(AppointmentRequest request);
    public List<AppointmentResponse> getAllAppointmentDetails(List<String> queryParam, List<Object> queryValue,
                                                              List<QueryOperands> operands);
    public AppointmentResponse getAppointmentById(Integer id);

    public AppointmentResponse deleteAppointment(Integer appointmentId) ;

    public AppointmentResponse updateAppointment(Integer appointmentId ,AppointmentRequest request) ;
}
