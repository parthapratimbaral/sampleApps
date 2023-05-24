package com.partha.appointment.controller;

import com.partha.appointment.dto.AppointmentRequest;
import com.partha.appointment.dto.AppointmentResponse;
import com.partha.appointment.service.AppointmentService;
import com.partha.appointment.utility.HelperUtility;
import com.partha.appointment.utility.QueryOperands;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * User: Partha Pratim Baral
 * Topic :
 * Date: 5/17/2023
 */
@CrossOrigin(origins="http://localhost:4200/")
@RestController
@RequestMapping("/gateway/api")
public class AppointmentBookingController {

    private static final Logger logger = LoggerFactory.getLogger(AppointmentBookingController.class);

    @Autowired
    private AppointmentService appointmentService;

    @GetMapping("/ping")
    public String pingService() {

        logger.info(" pingService in controller method call");
        return "AppointmentService is Up and running";
    }

    @PostMapping("/appointments")
    public AppointmentResponse createAppointment(@Valid @RequestBody AppointmentRequest request) {

        logger.info(" AppointmentService in controller createAppointment method call "+request.toString());
        return appointmentService.saveAppointmentData(request);
    }
    @GetMapping("/appointments/{id}")
    public AppointmentResponse getAppointment(@PathVariable Integer id){
        logger.info(" AppointmentService in controller createAppointment method call "+id);

        return appointmentService.getAppointmentById(id);
    }

    @GetMapping("/appointments")
    public List<AppointmentResponse> getAppointments(
            @Valid @RequestParam(value = "id", required = false) Integer appointmentId,
            @Valid @RequestParam(value = "doctorName", required = false) String doctorName,
            @Valid @RequestParam(value = "status", required = false) String status,
            @Valid @RequestParam(value = "sortedby", required = false) String sortedby,
            @Valid @RequestParam(value = "searchby", required = false) String searchby,
            @Valid @RequestParam(value = "searchvalue", required = false) String searchvalue
    ) {

        logger.info(" getAllTodos in controller method call");
        List<String> qParam = new ArrayList<String>();
        List<Object> qValue = new ArrayList<Object>();
        List<QueryOperands> operands = new ArrayList<QueryOperands>();
        if(null != appointmentId && appointmentId != 0) {
            qParam.add("appointmentId");
            qValue.add(appointmentId);
            operands.add(QueryOperands.EQUAL_TO);
        }
        if(doctorName != null) {
            qParam.add("doctorName");
            qValue.add(doctorName);
            operands.add(QueryOperands.LIKE);
        }
        if(status != null) {
            qParam.add("status");
            qValue.add(status);
            operands.add(QueryOperands.LIKE);
        }
        if(sortedby != null) {
            qParam.add("sortedby");
            qValue.add(sortedby);
            operands.add(QueryOperands.EQUAL_TO);
        }
        if(searchby != null) {
            qParam.add("searchby");
            qValue.add(searchby);
            operands.add(QueryOperands.EQUAL_TO);
        }
        if(searchvalue != null) {
            qParam.add("searchvalue");
            qValue.add(searchvalue);
            operands.add(QueryOperands.LIKE);
        }
        return appointmentService.getAllAppointmentDetails(qParam, qValue, operands);
    }

    @DeleteMapping("/appointments/{appointmentId}")
    public AppointmentResponse delete(@PathVariable Integer appointmentId){
        return appointmentService.deleteAppointment(appointmentId);
    }

    @PutMapping("/appointments/{appointmentId}")
    public AppointmentResponse updateAppointment(@PathVariable  Integer appointmentId,
                                                 @RequestBody AppointmentRequest request) {
        return appointmentService.updateAppointment(appointmentId, request);
    }
}
