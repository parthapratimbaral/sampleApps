package com.partha.appointment.dto;

import com.partha.appointment.entities.Status;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

/**
 * User: Partha Pratim Baral
 * Topic :
 * Date: 5/17/2023
 */
public class AppointmentResponse {

    public Integer id;
    public String patientName;
    public String indication;
    public String doctorName;
    public Date appointmentDate;
    public Date createdDate;
    public float appointmentTime;
    public Integer appointmentDuration;
    public String doctorSpeciality;
    public String status;
    public BigDecimal doctorFee;

    public AppointmentResponse() {
    }

    public AppointmentResponse(Integer id, String patientName, String indication, String doctorName, Date appointmentDate, Date createdDate, float appointmentTime, Integer appointmentDuration, String doctorSpeciality, String status, BigDecimal doctorFee) {
        this.id = id;
        this.patientName = patientName;
        this.indication = indication;
        this.doctorName = doctorName;
        this.appointmentDate = appointmentDate;
        this.createdDate = createdDate;
        this.appointmentTime = appointmentTime;
        this.appointmentDuration = appointmentDuration;
        this.doctorSpeciality = doctorSpeciality;
        this.status = status;
        this.doctorFee = doctorFee;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPatientName() {
        return patientName;
    }

    public String getIndication() {
        return indication;
    }

    public void setIndication(String indication) {
        this.indication = indication;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(Date appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
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

    public String getDoctorSpeciality() {
        return doctorSpeciality;
    }

    public void setDoctorSpeciality(String doctorSpeciality) {
        this.doctorSpeciality = doctorSpeciality;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AppointmentResponse that = (AppointmentResponse) o;
        return Float.compare(that.appointmentTime, appointmentTime) == 0 && Objects.equals(id, that.id) && Objects.equals(patientName, that.patientName) && Objects.equals(doctorName, that.doctorName) && Objects.equals(appointmentDate, that.appointmentDate) && Objects.equals(createdDate, that.createdDate) && Objects.equals(appointmentDuration, that.appointmentDuration) && Objects.equals(doctorSpeciality, that.doctorSpeciality) && Objects.equals(status, that.status) && Objects.equals(doctorFee, that.doctorFee);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, patientName, doctorName, appointmentDate, createdDate, appointmentTime, appointmentDuration, doctorSpeciality, status, doctorFee);
    }
}
