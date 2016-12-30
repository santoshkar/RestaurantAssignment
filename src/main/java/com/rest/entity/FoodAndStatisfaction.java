package com.rest.entity;

import java.io.Serializable;

/**
 * 
 * This is an entity object which would store data after reading the file.
 * 
 * @author Santosh_Kar
 */
public class FoodAndStatisfaction implements Serializable, Comparable<FoodAndStatisfaction> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer timeTakenInMinutes;
	private Integer maximumSatisfaction;
	private Float averageSatisfactionPerMinute;

	public Integer getTimeTakenInMinutes() {
		return timeTakenInMinutes;
	}

	public void setTimeTakenInMinutes(Integer timeTakenInMinutes) {
		this.timeTakenInMinutes = timeTakenInMinutes;
	}

	public Integer getMaximumSatisfaction() {
		return maximumSatisfaction;
	}

	public void setMaximumSatisfaction(Integer maximumSatisfaction) {
		this.maximumSatisfaction = maximumSatisfaction;
	}

	public Float getAverageSatisfactionPerMinute() {
		return averageSatisfactionPerMinute;
	}

	public void setAverageSatisfactionPerMinute(Float averageSatisfactionPerMinute) {
		this.averageSatisfactionPerMinute = averageSatisfactionPerMinute;
	}

	@Override
	public String toString() {
		return "FoodAndStatisfaction [timeTakenInMinutes=" + timeTakenInMinutes + ", maximumSatisfaction="
				+ maximumSatisfaction + ", averageSatisfactionPerMinute=" + averageSatisfactionPerMinute + "]";
	}

	public FoodAndStatisfaction(Integer timeTakenInMinutes, Integer maximumSatisfaction) {
		super();
		this.timeTakenInMinutes = timeTakenInMinutes;
		this.maximumSatisfaction = maximumSatisfaction;
		this.averageSatisfactionPerMinute = (float) maximumSatisfaction / (float) timeTakenInMinutes;
	}


	@Override
	public int compareTo(FoodAndStatisfaction o) {
		return this.getAverageSatisfactionPerMinute().compareTo(o.getAverageSatisfactionPerMinute());
	}
}
