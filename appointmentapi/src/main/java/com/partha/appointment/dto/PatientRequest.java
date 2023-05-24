package com.partha.appointment.dto;

import javax.persistence.*;

/**
 * User: Partha Pratim Baral
 * Topic :
 * Date: 5/21/2023
 */
public class PatientRequest {

    private Integer patientId;
    private Integer patientAppoId;
    private String patientName;
    private Integer patientAge;
    private String type; //Male Female child
    private String occupation;

    public PatientRequest() {
    }

    public PatientRequest(Integer patientId, Integer patientAppoId, String patientName, Integer patientAge, String type, String occupation) {
        this.patientId = patientId;
        this.patientAppoId = patientAppoId;
        this.patientName = patientName;
        this.patientAge = patientAge;
        this.type = type;
        this.occupation = occupation;
    }

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public Integer getPatientAppoId() {
        return patientAppoId;
    }

    public void setPatientAppoId(Integer patientAppoId) {
        this.patientAppoId = patientAppoId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public Integer getPatientAge() {
        return patientAge;
    }

    public void setPatientAge(Integer patientAge) {
        this.patientAge = patientAge;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }
}
