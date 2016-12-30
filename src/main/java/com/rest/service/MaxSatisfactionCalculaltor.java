package com.rest.service;

import java.util.Collections;
import java.util.List;

import com.rest.entity.FoodAndStatisfaction;

/**
 * 
 * This is containing the logic to find the maximum satisfaction value from a
 * given list.
 *
 * @author Santosh_Kar
 *
 */
public class MaxSatisfactionCalculaltor {

	public int findMaxSatisfaction(List<FoodAndStatisfaction> menuItems, int maxTimeAllowed) {

		/*
		 * The list is sorted into ascending order of the average time taken.
		 * This is useful to get the maximum satisfaction values on the top.
		 */
		Collections.sort(menuItems);
		Collections.reverse(menuItems);

		/*
		 * Initially the time remaining is the maxTimeAllowed in the restaurant
		 */
		int timeRemaining = maxTimeAllowed;

		int maxSatisFaction = 0;
		int actualTimeTaken = 0;

		/*
		 * Going through each menu items
		 */
		for (FoodAndStatisfaction menu : menuItems) {

			if (timeRemaining <= 0) {
				break;
			}

			if (menu.getTimeTakenInMinutes() < timeRemaining) {
				/* updating max satisfaction value */
				maxSatisFaction += menu.getMaximumSatisfaction();
				actualTimeTaken = menu.getTimeTakenInMinutes();

			} else {
				/*
				 * Else part will be executed when the time remaining is lesser
				 * than the amount of time taken for a dish. In that case it
				 * will be calculated as satisfaction = total time remaining x
				 * averageSatisfaction per minute.
				 */
				float satisfaction = timeRemaining * menu.getAverageSatisfactionPerMinute();
				satisfaction = Math.round(satisfaction);
				maxSatisFaction += satisfaction;

				actualTimeTaken = timeRemaining;
			}

			/*
			 * Updating the remaining time
			 */
			timeRemaining -= actualTimeTaken;

		}

		return maxSatisFaction;
	}
}
