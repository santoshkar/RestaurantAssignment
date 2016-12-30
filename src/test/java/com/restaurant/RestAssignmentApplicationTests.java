package com.restaurant;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.restaurant.dto.FileData;
import com.restaurant.exception.RestAssignException;
import com.restaurant.service.MaxSatisfactionCalculaltor;
import com.restaurant.service.RestaurantDataFileProcessor;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RestAssignmentApplicationTests {
	
	private int arrayTimeTaken[];
	private int arraySatisfaction[];
	private int totalItems;
			
	@Before
	public void init(){
		/*
		 * 
		 * satisfaction		time taken
		 *    100				20
		 *    60				30
		 *    200				22
		 *    105				15
		 * 
		 */
		arrayTimeTaken = new int[]{20, 30, 22, 15};
		arraySatisfaction = new int[]{100, 60, 200, 105};
		totalItems = 4;
	}

	@Test(expected = RestAssignException.class)
    public final void whenFileNameIsPassedEmpty() throws RestAssignException {
        new RestaurantDataFileProcessor().parseRestaurantFile("");
    }
	
	@Test(expected = RestAssignException.class)
    public final void whenFileDoesNotExist() throws RestAssignException {
        new RestaurantDataFileProcessor().parseRestaurantFile("FileDoesNotExist");
    }
	
	@Test
    public final void NoExceptionWhenFileExist() throws RestAssignException, IOException {
        new RestaurantDataFileProcessor().parseRestaurantFile("restaurant-data.txt");
        Assert.assertTrue(true);
    }
	
	@Test
	public final void testParseRestaurantFile() throws RestAssignException{
		RestaurantDataFileProcessor fileProcessor = new RestaurantDataFileProcessor();
		FileData fileData = fileProcessor.parseRestaurantFile("restaurant-data.txt");
		Assert.assertEquals(16808, fileData.getArraySatisfaction()[0]);
		Assert.assertEquals(250, fileData.getArrayTimeTaken()[0]);
	}
	
	@Test
	public final void testFindMaxSatisfaction(){
		
		int maxGivenTime = 42;	//when given time to choose dishes is 42
		MaxSatisfactionCalculaltor calc = new MaxSatisfactionCalculaltor();
		
		int maxSatisfaction = calc.findMaxSatisfaction(maxGivenTime, arrayTimeTaken, arraySatisfaction, totalItems);
		Assert.assertEquals(305, maxSatisfaction);
	}
	
	@Test
	public final void testFindMaxSatisfaction2(){
		
		int maxGivenTime = 40; //when given time to choose dishes is 40
		
		MaxSatisfactionCalculaltor calc = new MaxSatisfactionCalculaltor();
		
		int maxSatisfaction = calc.findMaxSatisfaction(maxGivenTime, arrayTimeTaken, arraySatisfaction, totalItems);
		Assert.assertEquals(305, maxSatisfaction);
	}
	
	@Test
	public final void testFindMaxSatisfaction3(){
		
		int maxGivenTime = 60;	//when given time to choose dishes is 60
		
		MaxSatisfactionCalculaltor calc = new MaxSatisfactionCalculaltor();
		
		int maxSatisfaction = calc.findMaxSatisfaction(maxGivenTime, arrayTimeTaken, arraySatisfaction, totalItems);
		Assert.assertEquals(405, maxSatisfaction);
	}
}
