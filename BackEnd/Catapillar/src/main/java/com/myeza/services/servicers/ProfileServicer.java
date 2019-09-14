package com.myeza.services.servicers;

import java.time.Instant;

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
	public Mono<Profile> findById(String id){
		return profileRepo.findById(id);
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
	public Mono<Campaign> findProfileCampaignByName(String profileId,String name) {
		// TODO Auto-generated method stub
		return campaignService.findCampaignByName(name).filter(campaign -> {
			for(Profile profile : campaign.getOwners()) {
				if(profile.getId().equalsIgnoreCase(profileId)) {
					return true;
				}
			}
			return false;
		});
	}

	@Override
	public Flux<Campaign> findProfileCampaigns(String profileId) {
		// TODO Auto-generated method stub
		return campaignService.findCampaigns().filter(campaign -> {
			for(Profile profile : campaign.getOwners()) {
				if(profile.getId().equalsIgnoreCase(profileId)) {
					return true;
				}
			}
			return false;
		});
	}

	@Override
	public Flux<Campaign> findProfileCampaignsByDateAscending(String profileId) {
		// TODO Auto-generated method stub
		return campaignService.findCampaignsByDateAscending()
				.filter(campaign -> {
					for(Profile profile : campaign.getOwners()) {
						if(profile.getId().equalsIgnoreCase(profileId)) {
							return true;
						}
					}
					return false;
				});
	}

	@Override
	public Flux<Campaign> findProfileCampaignsByEngagement(String profileId) {
		// TODO Auto-generated method stub
		return campaignService.findCampaignsByEngagement()
				.filter(campaign -> {
					for(Profile profile : campaign.getOwners()) {
						if(profile.getId().equalsIgnoreCase(profileId)) {
							return true;
						}
					}
					return false;
				});
	}

	@Override
	public Flux<Campaign> findProfileCampaignsByAge(String profileId) {
		// TODO Auto-generated method stub
		return campaignService.findCampaignsByAge()
				.filter(campaign -> {
					for(Profile profile : campaign.getOwners()) {
						if(profile.getId().equalsIgnoreCase(profileId)) {
							return true;
						}
					}
					return false;
				});
	}

	@Override
	public Flux<Campaign> findProfileCampaignByDateDescending(String profileId) {
		// TODO Auto-generated method stub
		return campaignService.findCampaignByDateDescending()
				.filter(campaign -> {
					for(Profile profile : campaign.getOwners()) {
						if(profile.getId().equalsIgnoreCase(profileId)) {
							return true;
						}
					}
					return false;
				});
	}

	@Override
	public Flux<Campaign> findProfileCampaignsAfterDate(String profileId,Instant date) {
		// TODO Auto-generated method stub
		return campaignService.findCampaignsAfterDate(date)
				.filter(campaign -> {
					for(Profile profile : campaign.getOwners()) {
						if(profile.getId().equalsIgnoreCase(profileId)) {
							return true;
						}
					}
					return false;
				});
	}

	@Override
	public Flux<Campaign> findProfileCampaignsBeforeDate(String profileId, Instant date) {
		// TODO Auto-generated method stub
		
		return campaignService.findCampaignsBeforeDate(date)
				.filter(campaign -> {
					for(Profile profile : campaign.getOwners()) {
						if(profile.getId().equalsIgnoreCase(profileId)) {
							return true;
						}
					}
					return false;
				});
	}

}
