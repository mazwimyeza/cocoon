package com.myeza.repositories;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.myeza.models.Profile;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProfileRepository extends ReactiveMongoRepository<Profile, String> {

	Flux<Profile> findByName(String name);
	Mono<Profile> findById(String id);

}
