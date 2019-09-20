package com.myeza.services.servicers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myeza.models.Campaign;
import com.myeza.models.Post;
import com.myeza.repositories.CampaignRepository;
import com.myeza.services.CampaignService;
import com.myeza.services.PostService;


@Service
public class CampaignServicer implements CampaignService {

	@Autowired
	CampaignRepository campaignRepo;
	
	@Autowired
	PostService postService;
	

	@Override
	public Campaign save(Campaign campaign) {
		// TODO Auto-generated method stub
		return this.campaignRepo.save(campaign);
	}

	@Override
	public Campaign update(Campaign campaign) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Campaign findCampaignByName(String name) {
		// TODO Auto-generated method stub
		return this.campaignRepo.findByTagline(name);
	}

	@Override
	public List<Campaign> findCampaigns() {
		// TODO Auto-generated method stub
		return this.campaignRepo.findAll();
	}

	@Override
	public List<Campaign> findCampaignsByDateAscending() {
		// TODO Auto-generated method stub
		return this.campaignRepo.findAllOrderByFirstOccurance();
	}

	@Override
	public List<Campaign> findCampaignsByEngagement() {
		// TODO Auto-generated method stub
		return this.campaignRepo.findAllOrderByEngagements();
	}

	@Override
	public List<Campaign> findCampaignsByAge() {
		// TODO Auto-generated method stub
		return this.campaignRepo.findAllByDuration();
	}

	@Override
	public List<Campaign> findCampaignByDateDescending() {
		// TODO Auto-generated method stub
		return this.campaignRepo.findAllOrderByLastOccurance();
	}

	@Override
	public List<Campaign> findCampaignsAfterDate(LocalDate date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Campaign> findCampaignsBeforeDate(LocalDate date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Post> getCampaignPostsByEndorsement(String campaignID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Post> getCampaignPostsByEngagement(String campaignId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Post> getCampaignPostsFromDate(String campaignId, LocalDate date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Post> getCampaignPostBeforeDate(String campaignId, LocalDate date) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
