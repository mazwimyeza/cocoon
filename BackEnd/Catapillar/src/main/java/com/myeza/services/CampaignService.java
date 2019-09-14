package com.myeza.services;

import java.time.Instant;

import com.myeza.models.Campaign;
import com.myeza.models.Post;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CampaignService {
	
	Mono<Campaign> save(Campaign campaign);
	
	Mono<Campaign> update(Campaign campaign);
	
	Mono<Campaign> findCampaignByName(String name);
	
	Flux<Campaign> findCampaigns();
	
	Flux<Campaign> findCampaignsByDateAscending();
	
	Flux<Campaign> findCampaignsByEngagement();
	
	Flux<Campaign> findCampaignsByAge();
	
	Flux<Campaign> findCampaignByDateDescending();
	
	Flux<Campaign> findCampaignsAfterDate(Instant date);
	
	Flux<Campaign> findCampaignsBeforeDate(Instant date);
	
	// TODO insert post services
	
	Flux<Post> getCampaignPostsByEndorsement(String campaignID);
	
	Flux<Post> getCampaignPostsByEngagement(String campaignId);
	
	Flux<Post> getCampaignPostsFromDate(String campaignId, Instant date);
	
	Flux<Post> getCampaignPostBeforeDate(String campaignId, Instant date);
	
	// TODO add aggregate functions...
	
}
