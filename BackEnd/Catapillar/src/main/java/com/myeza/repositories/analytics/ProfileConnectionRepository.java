package com.myeza.repositories.analytics;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.myeza.models.analytics.ProfileConnection;

@Repository
public interface ProfileConnectionRepository extends MongoRepository<ProfileConnection, String> {
	
	

}
