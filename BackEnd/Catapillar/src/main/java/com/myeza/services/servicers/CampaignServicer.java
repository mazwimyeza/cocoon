package com.myeza.services.servicers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.myeza.models.Campaign;
import com.myeza.models.Post;
import com.myeza.models.Profile;
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
		Campaign existingCampaign = this.campaignRepo.findByTagline(campaign.getTagline());
		if(existingCampaign == null)
			return this.campaignRepo.save(campaign);
		campaign.setId(existingCampaign.getId());
		int engagement = campaign.getEngagements() + existingCampaign.getEngagements();
		campaign.setEngagements(engagement);
		if(campaign.getFirstOccurance().isAfter(existingCampaign.getFirstOccurance()))
			campaign.setFirstOccurance(existingCampaign.getFirstOccurance());
		if(campaign.getLastOccurance().isBefore(existingCampaign.getLastOccurance()))
			campaign.setLastOccurance(existingCampaign.getLastOccurance());
		Set<Profile> owners = new HashSet<Profile>();
		owners.addAll(campaign.getOwners());
		owners.addAll(existingCampaign.getOwners());
		List<Profile> owning = new ArrayList<>(owners);
		campaign.setOwners(owning);
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
		return this.campaignRepo.findAll(new Sort(Sort.Direction.DESC, "engagements"));
	}

	@Override
	public List<Campaign> findCampaignsByDateAscending() {
		// TODO Auto-generated method stub
		return this.campaignRepo.findAllOrderByFirstOccurance();
	}

	@Override
	public List<Campaign> findCampaignsByEngagement() {
		// TODO Auto-generated method stub
		return this.campaignRepo.findAll();
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
