package com.myeza.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.myeza.models.Campaign;



public interface CampaignRepository extends MongoRepository<Campaign, String> {

	Campaign findByTagline(String name);

	List<Campaign> findAllOrderByFirstOccurance();

	List<Campaign> findAllOrderByEngagements();

	List<Campaign> findAllOrderByLastOccurance();

	List<Campaign> findAllByFirstOccuranceAfter(LocalDate date);

	List<Campaign> findAllByFirstOccuranceBefore(LocalDate date);

	List<Campaign> findAllByDuration();

}
