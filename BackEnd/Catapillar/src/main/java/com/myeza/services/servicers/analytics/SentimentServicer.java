package com.myeza.services.servicers.analytics;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myeza.models.analytics.MonthSentiment;
import com.myeza.services.CampaignService;
import com.myeza.services.PostSentimentService;
import com.myeza.services.ProfileService;
import com.myeza.services.analytics.CampaignSentimentService;
import com.myeza.services.analytics.SentimentService;

@Service
public class SentimentServicer implements SentimentService {
	
	@Autowired
	ProfileService profileService;
	
	@Autowired
	CampaignService campaignService;
	
	@Autowired
	PostSentimentService postSentiment;
	
	@Autowired
	CampaignSentimentService campaignSentiment;

	@Override
	public List<MonthSentiment> getProfileSentiment(String profileId) {
		
		HashMap<LocalDate, MonthSentiment> sentiments = new HashMap<>();
		
		this.profileService.findProfileCampaigns(profileId).forEach(campaign -> {
			/*this.campaignService.getCampaignPosts(campaign).forEach(post -> {
				int sentiment = this.postSentiment.getSentiment(post.getText());
				YearMonth yearMonth = YearMonth.of(post.getCreatedAt().getYear(), post.getCreatedAt().getMonth());
				LocalDate period = yearMonth.atEndOfMonth();
				if(sentiments.containsKey(period)) {
					sentiments.get(period).setSentiment(sentiment);
				}else {
					MonthSentiment initialSentiment = new MonthSentiment(period);
					initialSentiment.setSentiment(sentiment);
					sentiments.put(period, initialSentiment);
				}
			});*/
			this.campaignSentiment.findCampaignSentiments(campaign).forEach(sentiment -> {
				LocalDate key = sentiment.getYearMonth();
				if(sentiments.containsKey(key)) {
					sentiments.get(key).setSentiment(sentiment.getSentiment());
				}else {
					sentiments.put(key, sentiment);
				}
			});;
			
		});
		return (List<MonthSentiment>) sentiments.values();
	}

	@Override
	public List<MonthSentiment> getCampaignSentiment(String campaignId) {
		
		/*HashMap<LocalDate, MonthSentiment> sentiments = new HashMap<>();
		this.campaignService.getCampaignPosts(this.campaignService.findCampaignByName(campaignId)).forEach(post -> {
			int sentiment = this.postSentiment.getSentiment(post.getText());
			YearMonth yearMonth = YearMonth.of(post.getCreatedAt().getYear(), post.getCreatedAt().getMonth());
			LocalDate period = yearMonth.atEndOfMonth();
			if(sentiments.containsKey(period)) {
				sentiments.get(period).setSentiment(sentiment);
			}else {
				MonthSentiment initialSentiment = new MonthSentiment(period);
				initialSentiment.setSentiment(sentiment);
				sentiments.put(period, initialSentiment);
			}
		});
		
		List<MonthSentiment> list = new ArrayList<>(sentiments.values());*/
		
		return this.campaignSentiment.findCampaignSentiments(this.campaignService.findCampaignByName(campaignId));
	}

}
