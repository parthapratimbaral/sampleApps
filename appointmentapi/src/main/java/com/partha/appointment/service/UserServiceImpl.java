package com.partha.appointment.service;

import com.partha.appointment.dao.UserDao;
import com.partha.appointment.dto.UserRequest;
import com.partha.appointment.dto.UserResponse;
import com.partha.appointment.repository.UserRepository;
import com.partha.appointment.utility.HelperUtility;
import com.partha.appointment.utility.QueryOperands;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * User: Partha Pratim Baral
 * Topic :
 * Date: 5/18/2023
 */

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    @Override
    public UserResponse saveUser(UserRequest request) {
        return HelperUtility.getUSerDto(userDao.saveUser(HelperUtility.getUserEntity(request)));
    }

    @Override
    public List<UserResponse> getAllUserDetails(List<String> queryParam, List<Object> queryValue,
                                          List<QueryOperands> operands) {

        return HelperUtility.convertUserEntityToDto(userDao.getAllUser(queryParam, queryValue, operands));
    }
}