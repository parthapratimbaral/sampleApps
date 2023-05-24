package com.partha.appointment.dao;

import com.partha.appointment.entities.User;
import com.partha.appointment.repository.AppointmentRepository;
import com.partha.appointment.repository.UserRepository;
import com.partha.appointment.utility.QueryOperands;
import com.partha.appointment.utility.UtilityConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * User: Partha Pratim Baral
 * Topic :
 * Date: 5/18/2023
 */

@Component
@Transactional
public class UserDaoImpl implements UserDao{

    private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

    @Autowired
    private UserRepository useRepository;

    @Override
    public User saveUser(User user) {
        return useRepository.save(user);
    }

    @Override
    public User getUserById(Integer userId) {
        Optional<User> user = useRepository.findById(userId);
        if (user.isPresent()) {
            return user.get();
        }else {
            return null;
        }
    }

    @Override
    public List<User> getAllUser(List<String> queryParam, List<Object> queryValue,
                                 List<QueryOperands> operands) {
        String filterCriteriaType = null;
        Object filterCriteriaValue = null;
        String filterOprandValue = null;
        if ((queryParam != null && !queryParam.isEmpty()) && (queryValue != null && !queryValue.isEmpty())
                && (operands != null && !operands.isEmpty())) {

            filterCriteriaType = queryParam.get(0);
            filterCriteriaValue = queryValue.get(0);
            filterOprandValue = operands.get(0).toString();
            List<User> userList = new ArrayList<>();

            if (filterCriteriaType.equals(UtilityConstant.QUERY_USER_PARAM_ID)) {
                logger.info("getAllUser method call : SELECT_USER_BY_ID");
                Optional<User> optional = useRepository.findById(Integer.parseInt(filterCriteriaType.toString()));
                if (optional.isPresent()) {
                    userList.add(optional.get());
                }
                return userList;
            }
            else if (filterCriteriaType.equals(UtilityConstant.QUERY_USER_PARAM_NAME)) {
                logger.info("getAllUser method call : SELECT_USER_BY_NAME");
                User user = useRepository.findByUsername(filterCriteriaValue.toString());
                if (user != null) {
                    userList.add(user);
                }
                return userList;
            }else {
                return null;
            }
        }else{
            return useRepository.findAll();
        }
    }
}
