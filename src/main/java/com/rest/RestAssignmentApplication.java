package com.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.rest.dto.FileData;
import com.rest.service.MaxSatisfactionCalculaltor;
import com.rest.service.RestaurantDataFileProcessor;

@SpringBootApplication
public class RestAssignmentApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(RestAssignmentApplication.class, args);
		
		MaxSatisfactionCalculaltor calc = new  MaxSatisfactionCalculaltor();

		RestaurantDataFileProcessor processor = new RestaurantDataFileProcessor();
		FileData fData = processor.parseRestaurantFile("restaurant-data.txt");
		int maxSatisfaction = calc.findMaxSatisfaction(fData.getMenuItems(), fData.getTimeAllowed());
		
		System.out.printf("\n\n\nMaximum Satisfaction is : %s\n\n\n", maxSatisfaction);

		
	}
}
