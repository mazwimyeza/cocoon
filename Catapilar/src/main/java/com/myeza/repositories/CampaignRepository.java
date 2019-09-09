package com.myeza.repositories;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.myeza.models.Campaign;

public interface CampaignRepository extends ReactiveMongoRepository<Campaign, String> {

}
