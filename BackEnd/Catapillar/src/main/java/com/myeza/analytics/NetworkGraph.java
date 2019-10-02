package com.myeza.analytics;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myeza.models.Campaign;
import com.myeza.models.Profile;
import com.myeza.models.analytics.CampaignConnection;
import com.myeza.models.analytics.CampaignProfileConnection;
import com.myeza.models.analytics.ProfileConnection;
import com.myeza.services.CampaignService;
import com.myeza.services.ProfileService;

@Service
public class NetworkGraph {

	@Autowired
	ProfileService profileService;

	@Autowired
	CampaignService campaignService;

	public Set<ProfileConnection> getProfileConnections() {

		Set<ProfileConnection> set = new HashSet<>(40);
		profileService.findAll().forEach(prof -> {
			profileService.findProfileCampaigns(prof.getId()).forEach(camp -> {
				if (camp.getEngagements() > 10000) {
					camp.getOwners().forEach(camps -> {
						if (!camps.getId().equals(prof.getId()))
							set.add(new ProfileConnection(prof, camps));
						return;
					});
				}
			});
		});

		return set;
	}

	public Set<CampaignProfileConnection> getCampaignProfileConnections() {
		Set<CampaignProfileConnection> connections = new HashSet<>(14000);

		this.profileService.findAll().forEach(profile -> {
			this.profileService.findProfileCampaigns(profile.getId()).forEach(campaign -> {
				if (campaign.getEngagements() > 10000) {
					connections.add(new CampaignProfileConnection(campaign, profile));
				}
			});
		});

		return connections;
	}

	/**
	 * Expensive and say nothing about the profiles.. brands
	 * 
	 * @deprecated
	 * @return
	 */
	public Set<CampaignConnection> getCampaignConnections() {
		Set<CampaignConnection> connections = new HashSet<>(20000);

		this.profileService.findAll().forEach(profile -> {
			this.profileService.findProfileCampaigns(profile.getId()).forEach(campaign -> {
				for (Campaign camp : this.profileService.findProfileCampaigns(profile.getId())) {
					if (!camp.getId().equals(campaign.getId())) {
						connections.add(new CampaignConnection(campaign, camp));
					}
				}
			});
		});

		return connections;
	}

}
