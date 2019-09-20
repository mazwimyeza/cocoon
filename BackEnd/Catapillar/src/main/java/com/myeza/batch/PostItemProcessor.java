package com.myeza.batch;

import java.util.ArrayList;
import java.util.List;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;

import com.myeza.models.Campaign;
import com.myeza.models.Post;
import com.myeza.services.CampaignService;

public class PostItemProcessor implements ItemProcessor<Tweet, Post> {

	@Autowired
	CampaignService campaignService;
	
	@Override
	public Post process(Tweet item) throws Exception {
		if (item.getHashtags() == null || item.getHashtags().isEmpty())
			return null;
		
		List<Campaign> campaigns = new ArrayList<>();
		for(String hashtag: item.getHashtags()) {
			Campaign exists = campaignService.findCampaignByName(hashtag);
			if(exists != null)
				campaigns.add(exists);
		}
		if(campaigns.isEmpty())
			return null;
		int endorsement = item.getLikes_count() + item.getRetweets_count();
		int engagements = item.getReplies_count();
		String text = item.getTweet();
		
		return new Post(null, text, item.getDate(), campaigns, endorsement, engagements);
	}

}
