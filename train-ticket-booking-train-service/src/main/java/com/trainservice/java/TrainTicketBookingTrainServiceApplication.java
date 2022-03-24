package com.trainservice.java;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class TrainTicketBookingTrainServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrainTicketBookingTrainServiceApplication.class, args);
	}

}
