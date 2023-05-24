package com.partha.appointment.entities;

import javax.persistence.*;

/**
 * User: Partha Pratim Baral
 * Topic :
 * Date: 5/21/2023
 */
@Entity
@Table(name = "PATIENT")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PATIENT_ID")
    private Integer patientId;

    @Column(name = "PATIENT_NAME")
    private String patientName;

    @Column(name = "AGE")
    private Integer patientAge;

    @Column(name = "PATIENT_TYPE")
    private String type; //Male Female child

    @Column(name = "OCCUPATION")
    private String occupation;

    public Patient() {
    }

    public Patient(Integer patientId, String patientName, Integer patientAge,
                   String type, String occupation) {
        this.patientId = patientId;
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
