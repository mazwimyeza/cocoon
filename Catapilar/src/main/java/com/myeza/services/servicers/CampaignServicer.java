package com.myeza.services.servicers;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.myeza.models.Campaign;
import com.myeza.models.Post;
import com.myeza.repositories.CampaignRepository;
import com.myeza.services.CampaignService;
import com.myeza.services.PostService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class CampaignServicer implements CampaignService {

	@Autowired
	CampaignRepository campaignRepo;
	
	@Autowired
	PostService postService;
	
	@Override
	public Mono<Campaign> save(Campaign campaign) {
		// TODO Auto-generated method stub
		return campaignRepo.save(campaign);
	}
	
	@Override
	public Mono<Campaign> update(Campaign campaign) {
		// TODO Auto-generated method stub
		return campaignRepo.findById(campaign.getId())
				.map(oldCampaign -> {
					if(campaign.getFirstOccurance() != null) {
						if(campaign.getFirstOccurance().before(oldCampaign.getFirstOccurance())) {
							oldCampaign.setFirstOccurance(campaign.getFirstOccurance());
						}
						else {
							if(oldCampaign.getLastOccurance() == null || (oldCampaign.getLastOccurance().before(campaign.getFirstOccurance()))) {
								oldCampaign.setLastOccurance(campaign.getFirstOccurance());
							}
						}
					}
					
					if(campaign.getEngagements() > 0) {
						oldCampaign.setEngagements(oldCampaign.getEngagements()+ campaign.getEngagements());
					}
					
					return oldCampaign;
				}).flatMap(this::save);
	}

	@Override
	public Mono<Campaign> findCampaignByName(String name) {
		// TODO Auto-generated method stub
		return campaignRepo.findByName(name);
	}

	@Override
	public Flux<Campaign> findCampaigns() {
		// TODO Auto-generated method stub
		return campaignRepo.findAll();
	}

	@Override
	public Flux<Campaign> findCampaignsByDateAscending() {
		// TODO Auto-generated method stub
		return campaignRepo.findAllOrderByFirstOccurance();
	}

	@Override
	public Flux<Campaign> findCampaignsByEngagement() {
		// TODO Auto-generated method stub
		return campaignRepo.findAllOrderByEngagements();
	}

	@Override
	public Flux<Campaign> findCampaignsByAge() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Flux<Campaign> findCampaignByDateDescending() {
		// TODO Auto-generated method stub
		return campaignRepo.findAllOrderByLastOccurance();
	}

	@Override
	public Flux<Campaign> findCampaignsAfterDate(Date date) {
		// TODO Auto-generated method stub
		return campaignRepo.findAllByDateFrom(date);
	}

	@Override
	public Flux<Campaign> findCampaignsBeforeDate(Date date) {
		// TODO Auto-generated method stub
		return campaignRepo.findAllByDateBefore(date);
	}

	@Override
	public Flux<Post> getPostsByEndorsement() {
		// TODO Auto-generated method stub
		return postService.findAllOrderByEndorsementDesc();
	}

	@Override
	public Flux<Post> getPostsByEngagement() {
		// TODO Auto-generated method stub
		return postService.findAllOrderByEngagementDesc();
	}

	@Override
	public Flux<Post> getPostsFromDate(Date date) {
		// TODO Auto-generated method stub
		return postService.findAllByDateFrom(date);
	}

	@Override
	public Flux<Post> getPostBeforeDate(Date date) {
		// TODO Auto-generated method stub
		return postService.findAllByDateBefore(date);
	}

}
