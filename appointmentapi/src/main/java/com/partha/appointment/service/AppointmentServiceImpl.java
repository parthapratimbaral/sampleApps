package com.partha.appointment.service;

import com.partha.appointment.dao.AppointmentDao;
import com.partha.appointment.dto.AppointmentRequest;
import com.partha.appointment.dto.AppointmentResponse;
import com.partha.appointment.entities.Appointment;
import com.partha.appointment.exceptions.AppointmentNotFoundException;
import com.partha.appointment.repository.AppointmentRepository;
import com.partha.appointment.repository.StatusRepository;
import com.partha.appointment.utility.HelperUtility;
import com.partha.appointment.utility.QueryOperands;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * User: Partha Pratim Baral
 * Topic :
 * Date: 5/17/2023
 */
@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    private AppointmentDao appointmentDao;

    @Override
    public AppointmentResponse saveAppointmentData(AppointmentRequest request) {
        Appointment entry = HelperUtility.getEntity(request);
        return HelperUtility.getDto(appointmentDao.saveAppointment(entry));
    }

    @Override
    public List<AppointmentResponse> getAllAppointmentDetails(List<String> queryParam, List<Object> queryValue,
                                                              List<QueryOperands> operands) {

        return HelperUtility.convertEntityToDto(appointmentDao.getAllAppointment(queryParam, queryValue, operands));
    }

    @Override
    public AppointmentResponse getAppointmentById(Integer id) {
        Appointment appointment = appointmentDao.findById(id);
        return HelperUtility.getDto(appointment);
    }

    @Override
    public AppointmentResponse deleteAppointment(Integer appointmentId){
        Appointment appointment = appointmentDao.findById(appointmentId);
        if (appointment == null) {
            throw new AppointmentNotFoundException(String.format("Unknown id %s", appointmentId));
        }else{
            appointmentDao.delete(appointment);
            return HelperUtility.getDto(appointment);
        }
    }

    @Override
    public AppointmentResponse updateAppointment(Integer appointmentId ,AppointmentRequest request) {
        Appointment appointment = appointmentDao.findById(appointmentId);
        appointment.setStatus(request.getStatus());
        return HelperUtility.getDto(appointmentDao.update(appointment));
    }
}

/*@Autowired
    private StatusRepository statusRepository;*/

    /*public AppointmentResponse create(AppointmentRequest request) {

        // Find the requested status - if it doesn't exist, we will not move forward.
        //Status status = findStatus(request.status);
        //Status status = null;

        Appointment appointment = new Appointment(
                request.getAppointmentId(),
                request.getCreatedAt(),
                request.getAppointmentDateTime(),
                request.getDuration(),
                request.getDoctorName(),
                request.getPatientName(),
                request.getStatus(),
                request.getPrice()
        );
        return from(appointmentRepository.save(appointment));
    }*/
/*
    public List<AppointmentResponse> list() {
        return appointmentRepository
                .findAll()
                .stream()
                .map(AppointmentService::from)
                .collect(Collectors.toList());
    }

    public AppointmentResponse find(final Long id) {
        return from(
                appointmentRepository
                        .findById(id)
                        .orElseThrow(() -> new IllegalArgumentException(String.format("Unknown id %s", id)))
        );
    }

    public AppointmentResponse update(final Long id, final String status) {

        // Find the requested appointment by ID - if it doesn't exist, we cannot update it
        final Appointment foundAppointment = appointmentRepository
                .findById(id)
                .orElseThrow(() -> new IllegalArgumentException(String.format("Unknown id %s", id)));

        //foundAppointment.setStatus(findStatus(status));

        return from(appointmentRepository.save(foundAppointment));
    }

    public AppointmentResponse delete(final Long id) {

        // Find the requested appointment by ID - if it doesn't exist, we cannot update it
        final Appointment foundAppointment = appointmentRepository
                .findById(id)
                .orElseThrow(() -> new IllegalArgumentException(String.format("Unknown id %s", id)));

        appointmentRepository.delete(foundAppointment);

        return from(foundAppointment);
    }

    public List<AppointmentResponse> search(Date start, Date end) {
        return appointmentRepository.findByDateOrderByPriceDesc(start, end)
                .stream()
                .map(AppointmentService::from)
                .collect(Collectors.toList());
    }

    *//*public Status findStatus(final String status) {
        return statusRepository
                .findOne(Example.of(new Status(status)))
                .orElseThrow(() -> new IllegalArgumentException(String.format("Unknown status %s", status)));
    }*//*

    private static AppointmentResponse from(Appointment appointment) {
        return new AppointmentResponse(
                appointment.getAppointmentId(),
                appointment.getCreatedAt(),
                appointment.getAppointmentDate(),
                appointment.getAppointmentDuration(),
                appointment.getDoctorName(),
                appointment.getPatientName(),
                appointment.getStatus(),
                appointment.getPrice());
    }*/
//}
