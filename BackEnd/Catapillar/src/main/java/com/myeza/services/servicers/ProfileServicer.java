package com.myeza.services.servicers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myeza.models.Campaign;
import com.myeza.models.Profile;
import com.myeza.repositories.ProfileRepository;
import com.myeza.services.CampaignService;
import com.myeza.services.ProfileService;

@Service
public class ProfileServicer implements ProfileService{

	@Autowired
	ProfileRepository profileRepo;
	
	
	@Autowired
	CampaignService campaignService;


	@Override
	public Profile save(Profile profile) {
	
		return this.profileRepo.save(profile);
	}


	@Override
	public Profile findById(String id) {
		// TODO Auto-generated method stub
		return this.profileRepo.findById(id).get();
	}


	@Override
	public List<Profile> findAll() {
		// TODO Auto-generated method stub
		return this.profileRepo.findAll();
	}


	@Override
	public Profile findByName(String name) {
		// TODO Auto-generated method stub
		return this.profileRepo.findByName(name);
	}


	@Override
	public Profile findByUsername(String username) {
		// TODO Auto-generated method stub
		return this.profileRepo.findByUsername(username);
	}


	@Override
	public Campaign findProfileCampaignByName(String profileId, String name) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Campaign> findProfileCampaigns(String profileId) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Campaign> findProfileCampaignsByDateAscending(String profileId) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Campaign> findProfileCampaignsByEngagement(String profileId) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Campaign> findProfileCampaignsByAge(String profileId) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Campaign> findProfileCampaignByDateDescending(String profileId) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Campaign> findProfileCampaignsAfterDate(String profileId, LocalDate date) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Campaign> findProfileCampaignsBeforeDate(String profileId, LocalDate date) {
		// TODO Auto-generated method stub
		return null;
	}


	
	
	}
