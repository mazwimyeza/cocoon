package com.myeza.services;

import java.time.LocalDate;
import java.util.List;

import com.myeza.models.Campaign;
import com.myeza.models.Post;

public interface CampaignService {

	Campaign save(Campaign campaign);

	Campaign update(Campaign campaign);

	Campaign findCampaignByName(String name);

	List<Campaign> findCampaigns();

	List<Campaign> findCampaignsByDateAscending();

	List<Campaign> findCampaignsByEngagement();

	List<Campaign> findCampaignsByAge();

	List<Campaign> findCampaignByDateDescending();

	List<Campaign> findCampaignsAfterDate(LocalDate date);

	List<Campaign> findCampaignsBeforeDate(LocalDate date);

	// TODO insert post services

	List<Post> getCampaignPostsByEndorsement(String campaignID);

	List<Post> getCampaignPostsByEngagement(String campaignId);

	List<Post> getCampaignPostsFromDate(String campaignId, LocalDate date);

	List<Post> getCampaignPostBeforeDate(String campaignId, LocalDate date);

	// TODO add aggregate functions...

}
