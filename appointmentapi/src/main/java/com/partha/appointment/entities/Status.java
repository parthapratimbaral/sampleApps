package com.partha.appointment.entities;

import javax.persistence.*;
import java.util.Set;

/**
 * User: Partha Pratim Baral
 * Topic :
 * Date: 5/17/2023
 */
@Entity
@Table(name = "STATUS")
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "STATUS_ID", updatable = false, nullable = false)
    private Long statusId;

    @Column(name = "STATUS_TEXT", updatable = false, nullable = false)
    private String statusText;

    @OneToMany(mappedBy = "status", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Appointment> appointments;

    public Status() {
    }

    public Status(Long statusId, String statusText, Set<Appointment> appointments) {
        this.statusId = statusId;
        this.statusText = statusText;
        this.appointments = appointments;
    }

    public Long getStatusId() {
        return statusId;
    }

    public void setStatusId(Long statusId) {
        this.statusId = statusId;
    }

    public String getStatusText() {
        return statusText;
    }

    public void setStatusText(String statusText) {
        this.statusText = statusText;
    }

    public Set<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(Set<Appointment> appointments) {
        this.appointments = appointments;
    }
}
