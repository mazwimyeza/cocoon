package com.myeza.batch;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.myeza.models.Profile;
import com.myeza.services.ProfileService;

@EnableMongoRepositories(basePackages = "com.myeza.repositories")
public class ProfileWriter implements ItemWriter<Profile> {

	@Autowired
	private ProfileService profileService;

	/*
	 * @Autowired private MongoTemplate template;
	 */

	@Override
	public void write(List<? extends Profile> items) throws Exception {

		for (Profile item : items) {
			profileService.save(item);
		}

	}

}
