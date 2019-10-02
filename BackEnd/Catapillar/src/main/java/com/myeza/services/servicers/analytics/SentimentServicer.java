package com.myeza.services.servicers.analytics;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.myeza.models.Campaign;
import com.myeza.models.Profile;
import com.myeza.models.analytics.MonthSentiment;
import com.myeza.services.CampaignService;
import com.myeza.services.PostService;
import com.myeza.services.ProfileService;
import com.myeza.services.analytics.SentimentService;

public class SentimentServicer implements SentimentService {
	
	@Autowired
	ProfileService profileService;
	
	@Autowired
	CampaignService campaignService;
	
	@Autowired
	PostService postService;

	@Override
	public List<MonthSentiment> getProfileSentiment(String profileId) {
		this.profileService.findProfileCampaigns(profileId).forEach(campaign -> {
			//this.postService.
		});
		return null;
	}

	@Override
	public List<MonthSentiment> getCampaignSentiment(String campaignId) {
		// TODO Auto-generated method stub
		return null;
	}

}
