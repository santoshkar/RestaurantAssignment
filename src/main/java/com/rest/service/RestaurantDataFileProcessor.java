package com.rest.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.rest.dto.FileData;
import com.rest.entity.FoodAndStatisfaction;
import com.rest.exception.RestAssignException;

/**
 * 
 * This class is reading the data from the file. This class is used to generate
 * the FileData object after taking data from the file.
 * 
 * @author Santosh_Kar
 *
 */
public class RestaurantDataFileProcessor {
	public FileData parseRestaurantFile(String fileName) throws RestAssignException {

		if (StringUtils.isEmpty(fileName)) {
			throw new RestAssignException("File name is mandatory");
		}

		FileData sortedFileData = new FileData();

		try{
			BufferedReader br = new BufferedReader(new FileReader(new File(fileName)));
	
			String val = "";
			String[] str;
	
			/*
			 * This regular expression is used so it may consider multiple spaced
			 * between the satisfaction on eating dish and the time taken
			 */
			String timeAndMenuItems = br.readLine();
			str = timeAndMenuItems.split("\\s+");
	
			/*
			 * First line of the file is used as the input for the maximum given
			 * time and no. of items.
			 */
			sortedFileData.setTimeAllowed(Integer.valueOf(str[0]));
			sortedFileData.setNoMenuItems(Integer.valueOf(str[1]));
	
			List<FoodAndStatisfaction> list = new ArrayList<>(Integer.valueOf(str[1]));
	
			/*
			 * Reading each line of the file and creating the list of entities.
			 */
			while (true) {
				val = br.readLine();
				if (val == null)
					break;
	
				if (val.trim().isEmpty())
					continue;
				str = val.split("\\s+");
	
				Integer satisfaction = Integer.valueOf(str[0]);
				Integer timeTaken = Integer.valueOf(str[1]);
	
				list.add(new FoodAndStatisfaction(timeTaken, satisfaction));
	
			}
	
			sortedFileData.setMenuItems(list);
			br.close();
		}catch(IOException e){
			throw new RestAssignException(e.getMessage(), e);
		}

		return sortedFileData;
	}
}
