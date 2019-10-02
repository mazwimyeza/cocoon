package com.myeza.models.analytics;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import lombok.AllArgsConstructor;
import lombok.Data;


public class MonthSentiment {
	
	@NotNull
	private final LocalDate yearMonth;
	
	private int sentimentAccumulator;
	
	@PositiveOrZero
	private double sentiment;
	
	@PositiveOrZero
	private int numberOfPosts;

	public MonthSentiment(LocalDate yearMonth) {
		this.yearMonth = yearMonth;
		this.sentiment = 0;
		this.sentimentAccumulator = 0;
		this.numberOfPosts = 0;
	}
	
	public void setSentiment(int sentiment) {
		this.sentimentAccumulator += sentiment;
		this.numberOfPosts++;
		
		this.sentiment = this.sentimentAccumulator/this.numberOfPosts;
	}
	
}
