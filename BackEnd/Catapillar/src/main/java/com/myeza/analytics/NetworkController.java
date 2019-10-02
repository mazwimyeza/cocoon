package com.myeza.analytics;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myeza.models.analytics.CampaignConnection;
import com.myeza.models.analytics.CampaignProfileConnection;
import com.myeza.models.analytics.ProfileConnection;
import com.myeza.repositories.analytics.CampaignProfileConnectionRepository;
import com.myeza.repositories.analytics.ProfileConnectionRepository;

@RequestMapping(path = "/network", produces = "application/json")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class NetworkController {

	@Autowired
	NetworkGraph network;
	
	@Autowired
	ProfileConnectionRepository profileConnects;
	
	@Autowired
	CampaignProfileConnectionRepository overviewConnects;

	@GetMapping("/profiles")
	public List<ProfileConnection> getProfileConnections() {
		return this.profileConnects.findAll();
	}
	
	@GetMapping("/overview")
	public List<CampaignProfileConnection> getConnections(){
		return this.overviewConnects.findAll();
	}
	
	@GetMapping("/initialize")
	public void initialize() {
		this.profileConnects.saveAll(this.network.getProfileConnections());
		this.overviewConnects.saveAll(this.network.getCampaignProfileConnections());
		
	}
	
	
	@GetMapping("/campaigns")
	@Deprecated
	public Set<CampaignConnection> getCampaignConnections(){
		return network.getCampaignConnections();
	}

}
