package com.myeza.repositories;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.myeza.models.Profile;


@Repository
public interface ProfileRepository extends MongoRepository<Profile, String> {

	
	Profile findByName(String name);
	Optional<Profile> findById(String id);
	
	@Query("{'platforms.username' : ?0}")
	Profile findByUsername(String username);

}
