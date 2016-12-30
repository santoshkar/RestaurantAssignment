package com.restaurant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.restaurant.dto.FileData;
import com.restaurant.service.MaxSatisfactionCalculaltor;
import com.restaurant.service.RestaurantDataFileProcessor;

@SpringBootApplication
public class RestAssignmentApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(RestAssignmentApplication.class, args);
		
		MaxSatisfactionCalculaltor calc = new  MaxSatisfactionCalculaltor();

		RestaurantDataFileProcessor processor = new RestaurantDataFileProcessor();
		FileData fdata = processor.parseRestaurantFile("restaurant-data.txt");
		int maxSatisfaction = calc.findMaxSatisfaction(fdata.getTimeAllowed(), fdata.getArrayTimeTaken(), fdata.getArraySatisfaction(), fdata.getNoMenuItems());
		
		System.out.printf("\n\n\nMaximum Satisfaction is : %s\n\n\n", maxSatisfaction);

		
	}
}
