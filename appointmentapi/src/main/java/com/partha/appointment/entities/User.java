package com.partha.appointment.entities;

import javax.persistence.*;

/**
 * User: Partha Pratim Baral
 * Topic :
 * Date: 5/18/2023
 */
@Entity
@Table(name = "USERS")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID", updatable = false)
    public Integer userId;

    @Column(name = "USER_NAME", updatable = false)
    public String username;

    @Column(name = "USER_PASS", updatable = false)
    public String userPass;

    @Column(name = "USER_ROLL", updatable = false)
    public String userRoll;

    @Column(name = "USER_FULL_NAME", updatable = false)
    public String userFullName;


    public User() {
    }

    public User(Integer userId, String username, String userPass, String userRoll, String userFullName) {
        this.userId = userId;
        this.username = username;
        this.userPass = userPass;
        this.userRoll = userRoll;
        this.userFullName = userFullName;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public String getUserRoll() {
        return userRoll;
    }

    public void setUserRoll(String userRoll) {
        this.userRoll = userRoll;
    }

    public String getUserFullName() {
        return userFullName;
    }

    public void setUserFullName(String userFullName) {
        this.userFullName = userFullName;
    }
}
