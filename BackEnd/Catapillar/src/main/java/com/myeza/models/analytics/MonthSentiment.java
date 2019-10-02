package com.myeza.models.analytics;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class MonthSentiment {
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((yearMonth == null) ? 0 : yearMonth.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MonthSentiment other = (MonthSentiment) obj;
		if (yearMonth == null) {
			if (other.yearMonth != null)
				return false;
		} else if (!yearMonth.equals(other.yearMonth))
			return false;
		return true;
	}

	@NotNull
	private final LocalDate yearMonth;
	
	private int sentimentAccumulator;
	
	@PositiveOrZero
	private int sentiment;
	

	
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
		
		double sent = this.sentimentAccumulator/(double)this.numberOfPosts;
		
		this.sentiment = (@PositiveOrZero int) Math.round(sent);
	}
	
}
