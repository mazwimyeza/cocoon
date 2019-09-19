package com.myeza.repositories;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.myeza.models.Profile;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface ProfileRepository extends ReactiveMongoRepository<Profile, String> {

	Mono<Profile> save(Profile profile);
	Flux<Profile> findByName(String name);
	Mono<Profile> findById(String id);
	
	@Query("{'platforms.username' : ?0}")
	Mono<Profile> findByUsername(String username);

}
