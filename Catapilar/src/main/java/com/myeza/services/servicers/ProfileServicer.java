package com.myeza.services.servicers;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.myeza.models.Campaign;
import com.myeza.models.Profile;
import com.myeza.repositories.ProfileRepository;
import com.myeza.services.CampaignService;
import com.myeza.services.ProfileService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class ProfileServicer implements ProfileService{

	@Autowired
	ProfileRepository profileRepo;
	
	@Autowired
	CampaignService campaignService;
	
	@Override
	public Mono<Profile> save(Profile profile) {
		return profileRepo.save(profile);
	}

	@Override
	public Mono<Profile> updateProfile(Profile profile) {
	   return profileRepo.findById(profile.getId())
			   .map(oldProfile -> {
				   if(profile.getCampaigns() != null) {
					   oldProfile.setCampaigns(profile.getCampaigns());
				   }
				   if(profile.getPlatforms() != null) {
					   oldProfile.setPlatforms(profile.getPlatforms());
				   }
				   if(profile.getName() != null) {
					   oldProfile.setName(profile.getName());
				   }

				   return oldProfile;
			   }).flatMap(this::save);
	}

	@Override
	public Flux<Profile> findAll() {
		return profileRepo.findAll();
	}

	@Override
	public Flux<Profile> findByName(String name) {
		// TODO Auto-generated method stub
		return profileRepo.findByName(name);
	}


	@Override
	public Mono<Campaign> findCampaignByName(String name) {
		// TODO Auto-generated method stub
		return campaignService.findCampaignByName(name);
	}

	@Override
	public Flux<Campaign> findCampaigns() {
		// TODO Auto-generated method stub
		return campaignService.findCampaigns();
	}

	@Override
	public Flux<Campaign> findCampaignsByDateAscending() {
		// TODO Auto-generated method stub
		return campaignService.findCampaignsByDateAscending();
	}

	@Override
	public Flux<Campaign> findCampaignsByEngagement() {
		// TODO Auto-generated method stub
		return campaignService.findCampaignsByEngagement();
	}

	@Override
	public Flux<Campaign> findCampaignsByAge() {
		// TODO Auto-generated method stub
		return campaignService.findCampaignsByAge();
	}

	@Override
	public Flux<Campaign> findCampaignByDateDescending() {
		// TODO Auto-generated method stub
		return campaignService.findCampaignByDateDescending();
	}

	@Override
	public Flux<Campaign> findCampaignsAfterDate(Date date) {
		// TODO Auto-generated method stub
		return campaignService.findCampaignsAfterDate(date);
	}

	@Override
	public Flux<Campaign> findCampaignsBeforeDate(Date date) {
		// TODO Auto-generated method stub
		
		return campaignService.findCampaignsBeforeDate(date);
	}

}
