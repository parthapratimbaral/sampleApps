package com.partha.appointment.entities;

import com.partha.appointment.utility.UtilityConstant;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Date;

/**
 * User: Partha Pratim Baral
 * Topic :
 * Date: 5/17/2023
 */
@Entity
@Table(name = "APPOINTMENT")
@NamedQuery(name = UtilityConstant.SELECT_APPOINTMENT_BY_ID, query = "SELECT a FROM Appointment a  WHERE a.appointmentId=:appointmentId")
@NamedQuery(name = UtilityConstant.SELECT_DOCTOR_BY_NAME_LIKE, query = "SELECT a FROM Appointment a  WHERE a.doctorName LIKE :doctorName")
@NamedQuery(name = UtilityConstant.SELECT_APPOINTMENT_BY_STATUS_LIKE, query = "SELECT a FROM Appointment a  WHERE a.status LIKE :status")
@NamedQuery(name = UtilityConstant.SELECT_ALL_APPOINTMENTS, query = "SELECT a FROM Appointment a")
@NamedQuery(name = UtilityConstant.DELETE_APPOINTMENT_BY_ID, query = "DELETE FROM Appointment a WHERE a.appointmentId=:appointmentId")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "APPOINTMENT_ID")
    private Integer appointmentId;

    @Column(name = "CREATED_AT", updatable = false)
    private Date createdAt;

    @Column(name = "APPOINTMENT_DATE")
    private Date appointmentDate;

    @Column(name = "APPOINTMENT_TIME")
    private float appointmentTime;

    @Column(name = "APPOINTMENT_DURATION")
    private Integer appointmentDuration;

    @Column(name = "DOCTOR_NAME")
    private String doctorName;

    @Column(name = "DOCTORS_PECIALITY")
    private String doctorSpeciality;

    @Column(name = "PATIENT_NAME")
    public String patientName;

    @Column(name = "INDICATION")
    public String indication;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "PRICE")
    private BigDecimal doctorFee;

    public Appointment() {
    }

    public Appointment(Integer appointmentId,
                       Date createdAt,
                       Date appointmentDate,
                       float appointmentTime,
                       Integer appointmentDuration,
                       String doctorName,
                       String doctorSpeciality,
                       String patientName,
                       String indication,
                       String status,
                       BigDecimal doctorFee) {
        this.appointmentId = appointmentId;
        this.createdAt = createdAt;
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
        this.appointmentDuration = appointmentDuration;
        this.doctorName = doctorName;
        this.doctorSpeciality = doctorSpeciality;
        this.patientName = patientName;
        this.indication = indication;
        this.status = status;
        this.doctorFee = doctorFee;
    }

    public Integer getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(Integer appointmentId) {
        this.appointmentId = appointmentId;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(Date appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public float getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(float appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public Integer getAppointmentDuration() {
        return appointmentDuration;
    }

    public void setAppointmentDuration(Integer appointmentDuration) {
        this.appointmentDuration = appointmentDuration;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getDoctorSpeciality() {
        return doctorSpeciality;
    }

    public void setDoctorSpeciality(String doctorSpeciality) {
        this.doctorSpeciality = doctorSpeciality;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getIndication() {
        return indication;
    }

    public void setIndication(String indication) {
        this.indication = indication;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getDoctorFee() {
        return doctorFee;
    }

    public void setDoctorFee(BigDecimal doctorFee) {
        this.doctorFee = doctorFee;
    }

}
