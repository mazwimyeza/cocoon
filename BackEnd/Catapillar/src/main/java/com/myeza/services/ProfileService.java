package com.myeza.services;

import java.time.LocalDate;

import com.myeza.models.Campaign;
import com.myeza.models.Profile;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public interface ProfileService {
	
	// Profile services
	Mono<Profile> save(Profile profile);

	Mono<Profile> updateProfile(Profile profile);
	
	Mono<Profile> findById(String id);
	
	Flux<Profile> findAll();
	
	Flux<Profile> findByName(String name);
	
	
	// Platform services
	Mono<Profile> findByUsername(String username);
	
	
	// Campaign services
	
	Mono<Campaign> findProfileCampaignByName(String profileId,String name);
	
	Flux<Campaign> findProfileCampaigns(String profileId);
	
	Flux<Campaign> findProfileCampaignsByDateAscending(String profileId);
	
	Flux<Campaign> findProfileCampaignsByEngagement(String profileId);
	
	Flux<Campaign> findProfileCampaignsByAge(String profileId);
	
	Flux<Campaign> findProfileCampaignByDateDescending(String profileId);
	
	Flux<Campaign> findProfileCampaignsAfterDate(String profileId, LocalDate date);
	
	Flux<Campaign> findProfileCampaignsBeforeDate(String profileId, LocalDate date);

	
	
	

}
