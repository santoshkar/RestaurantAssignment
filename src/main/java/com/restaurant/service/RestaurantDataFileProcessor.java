package com.restaurant.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.util.StringUtils;

import com.restaurant.dto.FileData;
import com.restaurant.exception.RestAssignException;

/**
 * 
 * This class is reading the data from the file. This class is used to generate
 * the FileData object after taking data from the file.
 * 
 * @author Santosh_Kar
 *
 */
public class RestaurantDataFileProcessor {
	
	/**
	 * 
	 * This method reads the data from the file. Each line in the file is the
	 * combination of amount of satisfaction and total time taken for any
	 * particular dish.
	 * 
	 * @param fileName
	 * @return FileData
	 * @throws RestAssignException
	 */
	public FileData parseRestaurantFile(String fileName) throws RestAssignException {

		if (StringUtils.isEmpty(fileName)) {
			throw new RestAssignException("File name is mandatory");
		}

		FileData fileData = new FileData();

		BufferedReader br = null;
				
		try{
			br = new BufferedReader(new FileReader(new File(fileName)));
	
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
			fileData.setTimeAllowed(Integer.valueOf(str[0]));
			fileData.setNoMenuItems(Integer.valueOf(str[1]));
	
			int[] arrayTimeTaken = new int[fileData.getNoMenuItems()];
			int[] arraySatisfaction = new int[fileData.getNoMenuItems()];
			/*
			 * Reading each line of the file and creating the list of entities.
			 */
			for (int i=0;i <= fileData.getNoMenuItems();i++) {
				val = br.readLine();
				if (val == null)
					break;
	
				if (val.trim().isEmpty())
					continue;
				str = val.split("\\s+");
	
				Integer satisfaction = Integer.valueOf(str[0]);
				Integer timeTaken = Integer.valueOf(str[1]);
	
				arrayTimeTaken[i] = timeTaken;
				arraySatisfaction[i] = satisfaction;
	
			}
	
			fileData.setArraySatisfaction(arraySatisfaction);
			fileData.setArrayTimeTaken(arrayTimeTaken);
		}catch(IOException e){
			throw new RestAssignException(e.getMessage(), e);
		}finally{
			if(br != null)
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}

		return fileData;
	}
}
