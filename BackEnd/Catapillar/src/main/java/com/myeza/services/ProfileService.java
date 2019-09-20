package com.myeza.services;

import java.time.LocalDate;
import java.util.List;

import com.myeza.models.Campaign;
import com.myeza.models.Profile;


public interface ProfileService {
	
	// Profile services
	Profile save(Profile profile);
	
	Profile findById(String id);
	
	List<Profile> findAll();
	
	Profile findByName(String name);
	
	
	// Platform services
	Profile findByUsername(String username);
	
	
	// Campaign services
	
	Campaign findProfileCampaignByName(String profileId,String name);
	
	List<Campaign> findProfileCampaigns(String profileId);
	
	List<Campaign> findProfileCampaignsByDateAscending(String profileId);
	
	List<Campaign> findProfileCampaignsByEngagement(String profileId);
	
	List<Campaign> findProfileCampaignsByAge(String profileId);
	
	List<Campaign> findProfileCampaignByDateDescending(String profileId);
	
	List<Campaign> findProfileCampaignsAfterDate(String profileId, LocalDate date);
	
	List<Campaign> findProfileCampaignsBeforeDate(String profileId, LocalDate date);

	
	
	

}
