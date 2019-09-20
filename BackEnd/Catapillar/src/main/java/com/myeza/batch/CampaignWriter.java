package com.myeza.batch;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.myeza.models.Campaign;
import com.myeza.services.CampaignService;

@EnableMongoRepositories(basePackages = "com.myeza.*")
public class CampaignWriter implements ItemWriter<List<Campaign>> {

	@Autowired
	CampaignService campaignService;

	@Override
	public void write(List<? extends List<Campaign>> items) throws Exception {

		for (List<Campaign> campaigns : items) {
			if (campaigns == null || campaigns.isEmpty())
				continue;
			for (Campaign campaign : campaigns) {
				campaignService.save(campaign);

			}

		}

	}

}
