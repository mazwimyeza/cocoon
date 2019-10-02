package com.myeza.services.analytics;

import java.util.List;

import com.myeza.models.Campaign;
import com.myeza.models.analytics.MonthSentiment;

public interface CampaignSentimentService {

	public List<MonthSentiment> findCampaignSentiments(Campaign campaign);
}
