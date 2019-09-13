package com.myeza.services;

import java.time.Instant;

import com.myeza.models.Campaign;
import com.myeza.models.Profile;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProfileService {
	
	// Profile services
	Mono<Profile> save(Profile profile);

	Mono<Profile> updateProfile(Profile profile);
	
	Flux<Profile> findAll();
	
	Flux<Profile> findByName(String name);
	
	// Platform services
	
	
	// Campaign services
	
	Mono<Campaign> findCampaignByName(String name);
	
	Flux<Campaign> findCampaigns();
	
	Flux<Campaign> findCampaignsByDateAscending();
	
	Flux<Campaign> findCampaignsByEngagement();
	
	Flux<Campaign> findCampaignsByAge();
	
	Flux<Campaign> findCampaignByDateDescending();
	
	Flux<Campaign> findCampaignsAfterDate(Instant date);
	
	Flux<Campaign> findCampaignsBeforeDate(Instant date);

	Mono<Profile> findById(String id);
	
	

}
