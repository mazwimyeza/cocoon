package com.myeza.analytics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myeza.services.CampaignService;
import com.myeza.services.PostService;
import com.myeza.services.analytics.CampaignSentimentService;

@RestController
public class SentimentInitializer {
	
	@Autowired
	CampaignService campaignService;
	
	@Autowired
	CampaignSentimentService sentiment;
	
	@Autowired
	PostService postService;
	
	@GetMapping("/internalOnly")
	public boolean initializeCampaignSentiments() {
		
		this.campaignService.findCampaigns().forEach(campaign -> {
			if(campaign.getEngagements() > 1000) {
				// initialize sentiment here
			}
		});
		
		return true;
		
	}

}
