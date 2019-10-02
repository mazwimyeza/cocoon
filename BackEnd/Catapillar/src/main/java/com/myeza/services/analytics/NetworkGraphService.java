package com.myeza.services.analytics;

import java.util.Set;

import com.myeza.models.analytics.CampaignConnection;
import com.myeza.models.analytics.CampaignProfileConnection;
import com.myeza.models.analytics.ProfileConnection;

public interface NetworkGraphService {
	
	public Set<ProfileConnection> getProfileConnections();
	
	public Set<CampaignProfileConnection> getCampaignProfileConnections();
	
	@Deprecated
	public Set<CampaignConnection> getCampaignConnections();

}
