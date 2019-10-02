package com.myeza.services.analytics;

import java.util.List;

import com.myeza.models.Campaign;
import com.myeza.models.analytics.CampaignSentiment;
import com.myeza.models.analytics.MonthSentiment;

public interface CampaignSentimentService {
	
	public CampaignSentiment save(CampaignSentiment Campaign);

	public List<MonthSentiment> findCampaignSentiments(Campaign campaign);
}
