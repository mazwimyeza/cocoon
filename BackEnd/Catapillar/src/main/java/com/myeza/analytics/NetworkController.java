package com.myeza.analytics;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myeza.models.analytics.CampaignConnection;
import com.myeza.models.analytics.CampaignProfileConnection;
import com.myeza.models.analytics.ProfileConnection;

@RequestMapping(path = "/network", produces = "application/json")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class NetworkController {

	@Autowired
	NetworkGraph network;

	@GetMapping("/profiles")
	public Set<ProfileConnection> getProfileConnections() {
		return network.getProfileConnections();
	}
	
	@GetMapping("/overview")
	public Set<CampaignProfileConnection> getConnections(){
		return network.getCampaignProfileConnections();
	}
	
	@GetMapping("/campaigns")
	@Deprecated
	public Set<CampaignConnection> getCampaignConnections(){
		return network.getCampaignConnections();
	}

}
