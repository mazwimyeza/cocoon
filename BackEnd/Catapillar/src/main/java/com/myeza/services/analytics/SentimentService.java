package com.myeza.services.analytics;

import java.util.List;

import com.myeza.models.analytics.MonthSentiment;

public interface SentimentService {
	
	public List<MonthSentiment> getProfileSentiment(String profileId);
	
	public List<MonthSentiment> getCampaignSentiment(String campaignId);

}
