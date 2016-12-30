package com.rest.dto;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

import com.rest.entity.FoodAndStatisfaction;

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

	private List<FoodAndStatisfaction> menuItems = Collections.emptyList();
	private int noMenuItems = 0;
	private int timeAllowed = 0;

	public List<FoodAndStatisfaction> getMenuItems() {
		return menuItems;
	}

	public void setMenuItems(List<FoodAndStatisfaction> menuItems) {
		this.menuItems = menuItems;
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

	@Override
	public String toString() {
		return "SortedFileData [list=" + menuItems + ", noMenuItems=" + noMenuItems + ", timeAllowed=" + timeAllowed
				+ "]";
	}
}
