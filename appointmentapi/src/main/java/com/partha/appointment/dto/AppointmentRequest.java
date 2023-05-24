package com.partha.appointment.dto;

import com.partha.appointment.dto.PatientRequest;
import com.partha.appointment.entities.Status;
import com.sun.istack.NotNull;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

/**
 * User: Partha Pratim Baral
 * Topic :
 * Date: 5/17/2023
 */
public class AppointmentRequest {


    public Integer appointmentId;
    public Date createdAt;
    public Date appointmentDate;
    public float appointmentTime;
    public Integer appointmentDuration;
    public String doctorName;
    public String doctorSpeciality;
    public String patientName;
    public String indication;

    public String status;
    public BigDecimal doctorFee;

    public PatientRequest patient;

    public AppointmentRequest() {
    }

    public AppointmentRequest(Integer appointmentId,
                              Date createdAt,
                              Date appointmentDate,
                              float appointmentTime,
                              Integer appointmentDuration,
                              String doctorName,
                              String doctorSpeciality,
                              String patientName,
                              String indication,
                              String status,
                              BigDecimal doctorFee,
                              PatientRequest patient) {
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
        this.patient = patient;
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

    public PatientRequest getPatient() {
        return patient;
    }

    public void setPatient(PatientRequest patient) {
        this.patient = patient;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AppointmentRequest that = (AppointmentRequest) o;
        return Float.compare(that.appointmentTime, appointmentTime) == 0 && Objects.equals(appointmentId, that.appointmentId) && Objects.equals(createdAt, that.createdAt) && Objects.equals(appointmentDate, that.appointmentDate) && Objects.equals(appointmentDuration, that.appointmentDuration) && Objects.equals(doctorName, that.doctorName) && Objects.equals(doctorSpeciality, that.doctorSpeciality) && Objects.equals(patientName, that.patientName) && Objects.equals(indication, that.indication) && Objects.equals(status, that.status) && Objects.equals(doctorFee, that.doctorFee);
    }

    @Override
    public int hashCode() {
        return Objects.hash(appointmentId, createdAt, appointmentDate, appointmentTime, appointmentDuration, doctorName, doctorSpeciality, patientName, indication, status, doctorFee);
    }
}
