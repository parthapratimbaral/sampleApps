package com.partha.appointment.controller;

import com.partha.appointment.dto.AppointmentRequest;
import com.partha.appointment.dto.AppointmentResponse;
import com.partha.appointment.dto.UserRequest;
import com.partha.appointment.dto.UserResponse;
import com.partha.appointment.service.UserService;
import com.partha.appointment.utility.QueryOperands;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * User: Partha Pratim Baral
 * Topic :
 * Date: 5/18/2023
 */
@RestController
@RequestMapping("/gateway/api")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @PostMapping("/users")
    public UserResponse createUser(@Valid @RequestBody UserRequest request) {
        logger.info(" AppointmentService in controller createUser method call");
        return userService.saveUser(request);
    }

    @GetMapping("/users")
    public List<UserResponse> getUser(
            @Valid @RequestParam(value = "userId", required = false) Integer userId,
            @Valid @RequestParam(value = "userName", required = false) String userName
    ) {
        logger.info(" AppointmentService in controller createUser method call");
        List<String> qParam = new ArrayList<String>();
        List<Object> qValue = new ArrayList<Object>();
        List<QueryOperands> operands = new ArrayList<QueryOperands>();
        if(null != userId && userId != 0) {
            qParam.add("userId");
            qValue.add(userId);
            operands.add(QueryOperands.EQUAL_TO);
        }
        if(userName != null) {
            qParam.add("userName");
            qValue.add(userName);
            operands.add(QueryOperands.LIKE);
        }
        return userService.getAllUserDetails(qParam, qValue, operands);
    }
}
