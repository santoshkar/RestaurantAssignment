package com.restaurant.service;

/**
 * 
 * This is containing the logic to find the maximum satisfaction value from a
 * given list. Method knapSackAlgorithm is based on KnapSack algorithm.
 *
 * @author Santosh_Kar
 *
 */
public class MaxSatisfactionCalculaltor {

	/**
	 * returns the maximum value in between 2 numbers.
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	private int findMaxValue(int a, int b) {
		return a > b ? a : b;
	}
	
	
	/**
	 * 
	 * This code is based on knapSack algorithm dynamic programming. It's a
	 * bottom up approach in dynamic programming.
	 * 
	 * @param maxGivenTime: The maximum Givem time that should be taken to have dishes
	 * @param timeTaken: The array which contains the time taken for each dish
	 * @param satisfaction: The array which contains the amount of satisfaction
	 * @param noOfItems: total no of dishes
	 * @return
	 */
	private int knapSackAlgorithm(int maxGivenTime, int timeTaken[], int satisfaction[], int noOfItems) {
        int index, capacity;
        int [][]arrSatisfactionAndTime = new int[noOfItems+1][maxGivenTime+1];
 
        for (index = 0; index <= noOfItems; index++) {
            for (capacity = 0; capacity <= maxGivenTime; capacity++) {
                if (index==0 || capacity==0)
                    arrSatisfactionAndTime[index][capacity] = 0;
                else if (timeTaken[index-1] <= capacity){
                    arrSatisfactionAndTime[index][capacity] = findMaxValue(satisfaction[index-1] + arrSatisfactionAndTime[index-1][capacity-timeTaken[index-1]],  arrSatisfactionAndTime[index-1][capacity]);
                }
                else{
                    arrSatisfactionAndTime[index][capacity] = arrSatisfactionAndTime[index-1][capacity];
                }
            }
        }
 
        return arrSatisfactionAndTime[noOfItems][maxGivenTime];
    }

	/**
	 * 
	 * @param maxGivenTime: The maximum Givem time that should be taken to have dishes
	 * @param timeTaken: The array which contains the time taken for each dish
	 * @param satisfaction: The array which contains the amount of satisfaction
	 * @param noOfItems: total no of dishes
	 * @return
	 */
	public int findMaxSatisfaction(int maxGivenTime, int timeTaken[], int satisfaction[], int noOfItems) {
		return knapSackAlgorithm(maxGivenTime, timeTaken, satisfaction, noOfItems);
	}

}
