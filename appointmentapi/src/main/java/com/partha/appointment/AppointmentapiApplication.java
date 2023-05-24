package com.partha.appointment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class AppointmentapiApplication {

	public static void main(String[] args) {

		SpringApplication.run(AppointmentapiApplication.class, args);
	}
}
