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
	
	Flux<Post> getPostsByEndorsement();
	
	Flux<Post> getPostsByEngagement();
	
	Flux<Post> getPostsFromDate(Instant date);
	
	Flux<Post> getPostBeforeDate(Instant date);
	
	// TODO add aggregate functions...
	
}
