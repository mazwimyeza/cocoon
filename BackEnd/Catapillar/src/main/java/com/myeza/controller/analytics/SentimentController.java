package com.myeza.controller.analytics;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myeza.models.analytics.MonthSentiment;
import com.myeza.services.CampaignService;
import com.myeza.services.ProfileService;
import com.myeza.services.analytics.SentimentService;

@RequestMapping("/sentiments")
@RestController
public class SentimentController {
	
	@Autowired
	SentimentService sentimentService;
	
	@Autowired
	ProfileService prof;
	
	@Autowired
	CampaignService campo;
	
	@GetMapping("/profiles/{id}")
	public List<MonthSentiment> getSentiments(@PathVariable("id") String id){
	
		return this.sentimentService.getProfileSentiment(id);
	}
	
	@GetMapping("/campaigns/{hashtag}")
	public List<MonthSentiment> getCampaignSentiments(@PathVariable("hashtag") String tagline){
		return this.sentimentService.getCampaignSentiment(tagline);
	}

}
