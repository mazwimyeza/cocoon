package com.myeza.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myeza.models.Campaign;
import com.myeza.services.CampaignService;

@RequestMapping("/campaigns")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CampaignController {
	
	@Autowired
	CampaignService campaignService;
	
	@GetMapping()
	public List<Campaign> getCampaigns(){
		return this.campaignService.findCampaigns();
	}
	
	@GetMapping("/{tagline}")
	public Campaign getCampaign(@PathVariable("tagline") String tagline) {
		return this.campaignService.findCampaignByName(tagline);
	}

}
