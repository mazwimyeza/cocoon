package com.myeza.batch;

import java.util.ArrayList;
import java.util.List;

import org.springframework.batch.item.ItemProcessor;

import com.myeza.models.Platform;
import com.myeza.models.Profile;

public class ProfileItemProcessor implements ItemProcessor<ProfileData, Profile> {

	@Override
	public Profile process(final ProfileData data) throws Exception {

		// map platform info

		String platform_name = "Twitter";
		String username = data.getUsername().toLowerCase();
		int audience = data.getFollowers();

		Platform platform = new Platform(platform_name, username, audience);

		List<Platform> platforms = new ArrayList<>();
		platforms.add(platform);

		// map profile info
		String id = data.getId();
		String name = data.getName();
		Profile profile = new Profile();

		profile.setId(id);
		profile.setName(name);
		profile.setPlatforms(platforms);

		return profile;
	}

}
