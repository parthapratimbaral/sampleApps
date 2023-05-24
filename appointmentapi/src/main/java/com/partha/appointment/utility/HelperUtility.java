package com.partha.appointment.utility;

import com.partha.appointment.controller.AppointmentBookingController;
import com.partha.appointment.dto.AppointmentRequest;
import com.partha.appointment.dto.AppointmentResponse;
import com.partha.appointment.dto.UserRequest;
import com.partha.appointment.dto.UserResponse;
import com.partha.appointment.entities.Appointment;
import com.partha.appointment.entities.Patient;
import com.partha.appointment.entities.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * User: Partha Pratim Baral
 * Topic :
 * Date: 5/18/2023
 */
public class HelperUtility {

    private static final Logger logger = LoggerFactory.getLogger(HelperUtility.class);

    public static Appointment getEntity(AppointmentRequest request){

        Appointment appointment = new Appointment();

        appointment.setCreatedAt(convertSystemTimeToDate(System.currentTimeMillis()));
        appointment.setAppointmentDate(request.getAppointmentDate());
        appointment.setAppointmentTime(request.getAppointmentTime());
        appointment.setAppointmentDuration(request.getAppointmentDuration());
        appointment.setDoctorName(request.getDoctorName());
        appointment.setDoctorSpeciality(request.getDoctorSpeciality());
        appointment.setPatientName(request.getPatientName());
        appointment.setIndication(request.getIndication());
        appointment.setStatus(request.getStatus());
        appointment.setStatus(request.getStatus());
        appointment.setDoctorFee(request.getDoctorFee());
        return appointment;
    }

    public static AppointmentResponse getDto(Appointment entity){

        AppointmentResponse reponse = new AppointmentResponse();
        reponse.setCreatedDate(entity.getCreatedAt());
        reponse.setAppointmentDate(entity.getAppointmentDate());
        reponse.setAppointmentTime(entity.getAppointmentTime());
        reponse.setAppointmentDuration(entity.getAppointmentDuration());
        reponse.setDoctorName(entity.getDoctorName());
        reponse.setPatientName(entity.getPatientName());
        reponse.setIndication(entity.getIndication());
        reponse.setStatus(entity.getStatus());
        reponse.setDoctorSpeciality(entity.getDoctorSpeciality());
        reponse.setDoctorFee(entity.getDoctorFee());
        return reponse;
    }

    public static List<AppointmentResponse> convertEntityToDto(List<Appointment> appointmentments ){
        List<AppointmentResponse> aList = new ArrayList<>();
        for (Appointment appointment : appointmentments) {
            AppointmentResponse appointmentResponse = new AppointmentResponse();
            appointmentResponse.setId(appointment.getAppointmentId());
            appointmentResponse.setPatientName(appointment.getPatientName());
            appointmentResponse.setIndication(appointment.getIndication());
            appointmentResponse.setCreatedDate(appointment.getCreatedAt());
            appointmentResponse.setAppointmentDate(appointment.getAppointmentDate());
            appointmentResponse.setAppointmentTime(appointment.getAppointmentTime());
            appointmentResponse.setDoctorName(appointment.getDoctorName());
            appointmentResponse.setAppointmentDuration(appointment.getAppointmentDuration());
            appointmentResponse.setDoctorSpeciality(appointment.getDoctorSpeciality());
            appointmentResponse.setStatus(appointment.getStatus());
            appointmentResponse.setDoctorFee(appointment.getDoctorFee());

            aList.add(appointmentResponse);
        }
        return aList;
    }

    public static Date convertSystemTimeToDate(long timeNow){
        SimpleDateFormat sdf = new SimpleDateFormat("MMM dd,yyyy HH:mm");
        Date resultdate = new Date(timeNow);
        logger.info(sdf.format(resultdate));
        return resultdate;
    }

    public static User getUserEntity(UserRequest request){
        User user = new User();
        user.setUserId(request.getUserId());
        user.setUsername(request.getUserName());
        user.setUserPass(request.getUserPass());
        user.setUserRoll(request.getUserRoll());
        user.setUserFullName(request.getUserFullName());
        return user;
    }

    public static UserResponse getUSerDto(User entity){

        UserResponse reponse = new UserResponse();
        reponse.setUserId(entity.getUserId());
        reponse.setUserName(entity.getUsername());
        reponse.setUserPass(entity.getUserPass());
        reponse.setUserRoll(entity.getUserRoll());
        reponse.setUserFullName(entity.getUserFullName());
        return reponse;
    }

    public static List<UserResponse> convertUserEntityToDto(List<User> users ){
        List<UserResponse> aList = new ArrayList<>();
        for (User user : users) {
            UserResponse userResponse = new UserResponse();
            userResponse.setUserId(user.getUserId());
            userResponse.setUserName(user.getUsername());
            userResponse.setUserPass(user.getUserPass());
            userResponse.setUserRoll(user.getUserRoll());
            userResponse.setUserFullName(user.getUserFullName());
            aList.add(userResponse);
        }
        return aList;
    }





















    public static Map<String, List<? extends Object>>  getQueryParameters(Integer appointmentId,
                                                                          String doctorName,String status){
        List<String> qParam = new ArrayList<String>();
        List<Object> qValue = new ArrayList<Object>();
        List<QueryOperands> operands = new ArrayList<QueryOperands>();
        if(null != appointmentId && appointmentId != 0) {
            qParam.add("appointmentId");
            qValue.add(appointmentId);
            operands.add(QueryOperands.EQUAL_TO);
        }
        if(doctorName != null) {
            qParam.add("doctorName");
            qValue.add(doctorName);
            operands.add(QueryOperands.LIKE);
        }
        if(status != null) {
            qParam.add("status");
            qValue.add(status);
            operands.add(QueryOperands.LIKE);
        }
        Map<String, List<? extends Object>> aMap = new HashMap<>();
        aMap.put("Q_PARAM", qParam);
        aMap.put("Q_VALUE", qValue);
        aMap.put("OPRAND", operands);
        return aMap;
    }
}
