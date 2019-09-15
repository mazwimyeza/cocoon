package com.myeza.batch;

import org.springframework.core.convert.converter.Converter;
import java.time.LocalDate;
import java.time.LocalTime;

import com.mongodb.DBObject;

public class DocumentProfileConverter implements Converter<DBObject, ProfileData>{

	@Override
	public ProfileData convert(DBObject source) {
		ProfileData profile = new ProfileData();
		
		profile.setId((String)source.get("_id"));
		profile.setName((String)source.get("name"));
		profile.setUsername((String)source.get("username"));
		profile.setFollowers((int)source.get("followers"));
		profile.setFollowing((int)source.get("following"));
		profile.setLocation((String)source.get("location"));
		profile.setBackground_image((String)source.get("background_image"));
		profile.setProfile_image_url((String)source.get("profile_image_url"));
		profile.setPrivate_((int)source.get("private"));
		profile.setJoin_date((LocalDate)source.get("join_date"));
		profile.setJoin_time((LocalTime)source.get("join_time"));
		profile.setBio((String)source.get("bio"));
		profile.setVerified((int)source.get("verified"));
		profile.setMedia((int)source.get("media"));
		profile.setLikes((int)source.get("likes"));
		profile.setTweets((int)source.get("tweets"));
		
		return profile;
	}

}
