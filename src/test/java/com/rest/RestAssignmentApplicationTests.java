package com.rest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.rest.dto.FileData;
import com.rest.entity.FoodAndStatisfaction;
import com.rest.exception.RestAssignException;
import com.rest.service.MaxSatisfactionCalculaltor;
import com.rest.service.RestaurantDataFileProcessor;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RestAssignmentApplicationTests {

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
		Assert.assertEquals(16808, fileData.getMenuItems().get(0).getMaximumSatisfaction().intValue());
		Assert.assertEquals(250, fileData.getMenuItems().get(0).getTimeTakenInMinutes().intValue());
	}
	
	@Test
	public final void testFindMaxSatisfaction(){
		
		MaxSatisfactionCalculaltor calc = new MaxSatisfactionCalculaltor();
		List<FoodAndStatisfaction> menuItems = new ArrayList<>();
		FoodAndStatisfaction menu1 = new FoodAndStatisfaction(14, 28636);
		FoodAndStatisfaction menu2 = new FoodAndStatisfaction(7, 37336);
		FoodAndStatisfaction menu3 = new FoodAndStatisfaction(12, 46043);
		FoodAndStatisfaction menu4 = new FoodAndStatisfaction(25, 28550);
		FoodAndStatisfaction menu5 = new FoodAndStatisfaction(9, 41595);
		menuItems.add(menu1);
		menuItems.add(menu2);
		menuItems.add(menu3);
		menuItems.add(menu4);
		menuItems.add(menu5);
		
		int maxSatisfaction = calc.findMaxSatisfaction(menuItems, 28);
		Assert.assertEquals(124974, maxSatisfaction);
	}
	
	@Test
	public final void testFindMaxSatisfaction2(){
		
		MaxSatisfactionCalculaltor calc = new MaxSatisfactionCalculaltor();
		List<FoodAndStatisfaction> menuItems = new ArrayList<>();
		FoodAndStatisfaction menu1 = new FoodAndStatisfaction(14, 28636);
		FoodAndStatisfaction menu2 = new FoodAndStatisfaction(7, 37336);
		FoodAndStatisfaction menu3 = new FoodAndStatisfaction(12, 46043);
		FoodAndStatisfaction menu4 = new FoodAndStatisfaction(25, 28550);
		FoodAndStatisfaction menu5 = new FoodAndStatisfaction(9, 41595);
		menuItems.add(menu1);
		menuItems.add(menu2);
		menuItems.add(menu3);
		menuItems.add(menu4);
		menuItems.add(menu5);
		
		int maxSatisfaction = calc.findMaxSatisfaction(menuItems, 30);
		Assert.assertEquals(129065, maxSatisfaction);
	}
	
	@Test
	public final void testFindMaxSatisfaction3(){
		
		MaxSatisfactionCalculaltor calc = new MaxSatisfactionCalculaltor();
		List<FoodAndStatisfaction> menuItems = new ArrayList<>();
		FoodAndStatisfaction menu1 = new FoodAndStatisfaction(14, 28636);
		FoodAndStatisfaction menu2 = new FoodAndStatisfaction(7, 37336);
		FoodAndStatisfaction menu3 = new FoodAndStatisfaction(12, 46043);
		FoodAndStatisfaction menu4 = new FoodAndStatisfaction(25, 28550);
		FoodAndStatisfaction menu5 = new FoodAndStatisfaction(9, 41595);
		menuItems.add(menu1);
		menuItems.add(menu2);
		menuItems.add(menu3);
		menuItems.add(menu4);
		menuItems.add(menu5);
		
		int maxSatisfaction = calc.findMaxSatisfaction(menuItems, 31);
		Assert.assertEquals(131110, maxSatisfaction);
	}
}
