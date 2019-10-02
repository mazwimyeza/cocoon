package com.myeza.services.servicers.analytics;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myeza.models.Campaign;
import com.myeza.models.analytics.CampaignSentiment;
import com.myeza.models.analytics.MonthSentiment;
import com.myeza.repositories.analytics.CampaignSentimentRepository;
import com.myeza.services.analytics.CampaignSentimentService;

@Service
public class CampaignSentimentServicer implements CampaignSentimentService {

	@Autowired
	CampaignSentimentRepository sentimentRepo;
	
	@Override
	public List<MonthSentiment> findCampaignSentiments(Campaign campaign) {
		
		return this.sentimentRepo.findByCampaign(campaign).getMonthSentiments();
	}

	@Override
	public CampaignSentiment save(CampaignSentiment campaign) {
	
		return this.sentimentRepo.save(campaign);
	}

}
