package com.partha.appointment.dto;

/**
 * User: Partha Pratim Baral
 * Topic :
 * Date: 5/18/2023
 */
public class UserRequest {

    public Integer userId;
    public String userName;

    public String userPass;
    public String userRoll;
    public String userFullName;

    public UserRequest() {
    }

    public UserRequest(Integer userId, String userName, String userPass, String userRoll, String userFullName) {
        this.userId = userId;
        this.userName = userName;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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
