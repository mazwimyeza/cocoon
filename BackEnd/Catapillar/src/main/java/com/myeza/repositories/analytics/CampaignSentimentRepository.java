package com.myeza.repositories.analytics;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.myeza.models.Campaign;
import com.myeza.models.analytics.CampaignSentiment;

public interface CampaignSentimentRepository extends MongoRepository<CampaignSentiment, String>{
	
	CampaignSentiment findByCampaign(Campaign campaign);

}
