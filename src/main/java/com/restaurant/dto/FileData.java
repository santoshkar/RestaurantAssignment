package com.restaurant.dto;

import java.io.Serializable;

/**
 * This is an DTO object. This will hold the list of all entities of the
 * FoodAndSatisfaction. Also it would hold value of the maximum given time to be
 * used in the restaurant.
 * 
 * @author Santosh_Kar
 *
 */
public class FileData implements Serializable {

	private static final long serialVersionUID = -4323392940602781269L;

	private int[] arrayTimeTaken;
	private int[] arraySatisfaction;
	private int noMenuItems = 0;
	private int timeAllowed = 0;

	public int[] getArrayTimeTaken() {
		return arrayTimeTaken;
	}

	public void setArrayTimeTaken(int[] arrayTimeTaken) {
		this.arrayTimeTaken = arrayTimeTaken;
	}

	public int[] getArraySatisfaction() {
		return arraySatisfaction;
	}

	public void setArraySatisfaction(int[] arraySatisfaction) {
		this.arraySatisfaction = arraySatisfaction;
	}

	public int getNoMenuItems() {
		return noMenuItems;
	}

	public void setNoMenuItems(int noMenuItems) {
		this.noMenuItems = noMenuItems;
	}

	public int getTimeAllowed() {
		return timeAllowed;
	}

	public void setTimeAllowed(int timeAllowed) {
		this.timeAllowed = timeAllowed;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
