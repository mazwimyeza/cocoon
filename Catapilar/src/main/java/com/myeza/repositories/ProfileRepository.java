package com.myeza.repositories;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.myeza.models.Profile;

public interface ProfileRepository extends ReactiveMongoRepository<Profile, String> {

}
