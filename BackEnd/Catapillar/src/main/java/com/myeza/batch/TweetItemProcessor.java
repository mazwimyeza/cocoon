package com.myeza.batch;

import java.util.ArrayList;
import java.util.List;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;

import com.myeza.models.Campaign;
import com.myeza.models.Profile;
import com.myeza.services.ProfileService;

public class TweetItemProcessor implements ItemProcessor<Tweet, List<Campaign>> {

	@Autowired
	ProfileService profileService;

	@Override
	public List<Campaign> process(Tweet item) throws Exception {
		if (item.getHashtags() == null || item.getHashtags().isEmpty())
			return null;

		List<Campaign> campaigns = new ArrayList<>();

		List<Profile> profiles = new ArrayList<>();
		profiles.add(profileService.findByName(item.getName()));

		for (String hashtag : item.getHashtags()) {
			int engagements = item.getLikes_count() + item.getReplies_count() + item.getRetweets_count();
			Campaign campaign = new Campaign(null, hashtag, item.getDate(), item.getDate(), engagements, profiles);
			campaigns.add(campaign);
		}
		return campaigns;
	}

}
