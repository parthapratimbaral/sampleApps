package com.partha.appointment.dao;

import com.partha.appointment.entities.Appointment;
import com.partha.appointment.entities.User;
import com.partha.appointment.utility.QueryOperands;

import java.util.List;

/**
 * User: Partha Pratim Baral
 * Topic :
 * Date: 5/18/2023
 */
public interface UserDao {

    public User saveUser(User user);
    public User getUserById(Integer userId);
    public List<User> getAllUser(List<String> queryParam, List<Object> queryValue, List<QueryOperands> operands);
}
