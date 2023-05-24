package com.partha.appointment.service;

import com.partha.appointment.dto.UserRequest;
import com.partha.appointment.dto.UserResponse;
import com.partha.appointment.utility.QueryOperands;
import org.h2.engine.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * User: Partha Pratim Baral
 * Topic :
 * Date: 5/18/2023
 */
@Service
public interface UserService {

    public UserResponse saveUser(UserRequest request);
    public List<UserResponse> getAllUserDetails(List<String> queryParam, List<Object> queryValue,
                                          List<QueryOperands> operands);
}
