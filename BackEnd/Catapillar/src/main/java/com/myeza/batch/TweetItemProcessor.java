package com.myeza.batch;

import java.util.ArrayList;
import java.util.List;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;

import com.myeza.models.Campaign;
import com.myeza.models.Profile;
import com.myeza.services.ProfileService;

import reactor.core.publisher.Mono;

public class TweetItemProcessor implements ItemProcessor<Tweet, List<Campaign> > {

	@Autowired
	ProfileService profileService;
	
	@Override
	public List<Campaign> process(Tweet item) throws Exception {
		if (item.getHashtags() == null || item.getHashtags().isEmpty())
			return null;
		
		List<Campaign> campaigns = new ArrayList<>();
		
		List<Profile> profiles = new ArrayList<>();
		profileService.findByUsername(item.getUsername()).subscribe(
				profile -> profiles.add(profile),
				error -> error.printStackTrace(),
				() -> System.out.println("Completed without a value for campaign "+item.getHashtags().toString())
				);
		
		for(String hashtag: item.getHashtags()) {
			int engagements = item.getLikes_count() + item.getReplies_count() + item.getRetweets_count();
			Campaign campaign = new Campaign(item.getId(), hashtag, item.getDate(), item.getDate(), engagements, profiles);
			campaigns.add(campaign);
		}

		return campaigns;
	}

}
