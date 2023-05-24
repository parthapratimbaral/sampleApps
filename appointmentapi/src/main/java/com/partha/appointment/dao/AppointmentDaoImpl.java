package com.partha.appointment.dao;

import com.partha.appointment.entities.Appointment;
import com.partha.appointment.repository.AppointmentRepository;
import com.partha.appointment.utility.QueryOperands;
import com.partha.appointment.utility.UtilityConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * User: Partha Pratim Baral
 * Topic :
 * Date: 5/18/2023
 */
@Component
@Transactional
public class AppointmentDaoImpl implements AppointmentDao{

    private static final Logger logger = LoggerFactory.getLogger(AppointmentDaoImpl.class);

    @Autowired
    private AppointmentRepository appointmentRepository;
    @Override
    public Appointment saveAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    @Override
    public Appointment findById(Integer appointmentId) {
        Optional<Appointment> optional = appointmentRepository.findById(appointmentId);
        if (optional.isPresent()) {
            return optional.get();
        }else {
            return null;
        }
    }

    @Override
    public void delete(Appointment appointment) {

        appointmentRepository.delete(appointment);
    }

    @Override
    public Appointment update(Appointment appointment) {
        return appointmentRepository.saveAndFlush(appointment);
    }

    @Override
    public List<Appointment> getAllAppointment(List<String> queryParam, List<Object> queryValue,
                                               List<QueryOperands> operands) {
        String filterCriteriaType = null;
        Object filterCriteriaValue = null;
        String filterOprandValue = null;
        if ((queryParam != null && !queryParam.isEmpty()) && (queryValue != null && !queryValue.isEmpty())
                && (operands != null && !operands.isEmpty())) {

            filterCriteriaType = queryParam.get(0);
            filterCriteriaValue = queryValue.get(0);
            filterOprandValue = operands.get(0).toString();
            if(queryParam.size() > 1 && queryValue.size() > 1){
                logger.info("getAllAppointment method call : SELECT BY USER AND SORTED");
                if(queryParam.get(1).toString().equals("sortedby"))
                    return appointmentRepository.findByUserSearchAndSorted("sortedby",queryParam, queryValue);
                if(queryParam.get(1).toString().equals("searchby"))
                    return appointmentRepository.findByUserSearchAndSorted("searchby",queryParam, queryValue);
            } else if (filterCriteriaType.equals(UtilityConstant.QUERY_PARAM_ID)) {
                logger.info("getAllAppointment method call : SELECT_APPOINTMENT_BY_ID");
                return appointmentRepository.find(UtilityConstant.SELECT_APPOINTMENT_BY_ID, filterCriteriaType, filterCriteriaValue, filterOprandValue);
            } else if (filterCriteriaType.equals(UtilityConstant.QUERY_PARAM_NAME)) {
                logger.info("findAllDoctor method call : SELECT_DOCTOR_BY_NAME_LIKE");
                return appointmentRepository.find(UtilityConstant.SELECT_DOCTOR_BY_NAME_LIKE, filterCriteriaType, filterCriteriaValue, filterOprandValue);
            }else if (filterCriteriaType.equals(UtilityConstant.QUERY_PARAM_STATUS)) {
                logger.info("findAllDoctor method call : SELECT_DOCTOR_BY_SPECIALITY_LIKE");
                return appointmentRepository.find(UtilityConstant.SELECT_APPOINTMENT_BY_STATUS_LIKE, filterCriteriaType, filterCriteriaValue, filterOprandValue);
            } else if (filterCriteriaType.equals(UtilityConstant.QUERY_PARAM_SORTED_BY)) {
                logger.info("findAllDoctor method call : SELECT_APPOINTMENT_SORTED_BY");
                return appointmentRepository.find(UtilityConstant.SELECT_APPOINTMENT_SORTED_BY, filterCriteriaType, filterCriteriaValue, filterOprandValue);
            }
            else {
                logger.info("findAllDoctor method call : WITH NO PARAMETER");
                return appointmentRepository.findAll();
            }
        } else {
            logger.info("findAllDoctor method call : FIND ALL DOCTORS");
            return appointmentRepository.findAll();
        }
        return null;
    }
}
