package com.partha.appointment.utility;

/**
 * User: Partha Pratim Baral
 * Topic :
 * Date: 5/18/2023
 */
public interface UtilityConstant {

    final String QUERY_PARAM_ID = "appointmentId";
    final String QUERY_PARAM_NAME = "doctorName";
    final String QUERY_PARAM_STATUS = "status";
    final String QUERY_PARAM_SORTED_BY = "sortedby";
    final String SELECT_BY_USER_SOETED = "selectByUserAndSort";

    final String QUERY_USER_PARAM_ID = "userId";

    final String QUERY_USER_PARAM_NAME = "userName";

    // Queries
    final String SELECT_APPOINTMENT_BY_ID = "selectAppointmentByid";
    final String SELECT_DOCTOR_BY_NAME_LIKE = "selectDoctorByNameLike";
    final String SELECT_APPOINTMENT_BY_STATUS_LIKE = "selectAppointmentByStatusLike";
    final String SELECT_ALL_APPOINTMENTS = "selectAllAppointments";
    final String DELETE_APPOINTMENT_BY_ID = "deleteAppointmentById";
    final String SELECT_APPOINTMENT_SORTED_BY = "selectAppointmentBySorted";
}
