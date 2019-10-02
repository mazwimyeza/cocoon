package com.myeza.repositories.analytics;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.myeza.models.analytics.CampaignProfileConnection;

@Repository
public interface CampaignProfileConnectionRepository extends MongoRepository<CampaignProfileConnection, String> {

}
