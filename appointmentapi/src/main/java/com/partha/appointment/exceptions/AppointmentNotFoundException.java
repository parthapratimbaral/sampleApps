package com.partha.appointment.exceptions;

/**
 * User: Partha Pratim Baral
 * Topic :
 * Date: 5/18/2023
 */
public class AppointmentNotFoundException extends RuntimeException{

    public AppointmentNotFoundException(String message) {
        super(message);
    }
}
