package com.myeza.services;

import java.util.Date;

import com.myeza.models.Campaign;
import com.myeza.models.Post;
import com.myeza.models.Profile;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CampaignService {
	
	Mono<Campaign> save(Campaign campaign);
	
	Mono<Campaign> findCampaignByName(String name);
	
	Flux<Campaign> findCampaigns();
	
	Flux<Campaign> findCampaignsByDateAscending();
	
	Flux<Campaign> findCampaignsByEngagement();
	
	Flux<Campaign> findCampaignsByAge();
	
	Flux<Campaign> findCampaignByDateDescending();
	
	Flux<Campaign> findCampaignsAfterDate(Date date);
	
	Flux<Campaign> findCampaignsBeforeDate(Date date);
	
	// TODO insert post services
	
	Flux<Post> getPostsByEndorsement();
	
	Flux<Post> getPostsByEngagement();
	
	Flux<Post> getPostsFromDate(Date date);
	
	Flux<Post> getPostBeforeDate(Date date);
	
	// TODO add aggregate functions...
	
}
