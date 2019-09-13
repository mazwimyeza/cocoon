package com.myeza.repositories;

import java.time.Instant;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.myeza.models.Campaign;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CampaignRepository extends ReactiveMongoRepository<Campaign, String> {

	Mono<Campaign> findByName(String name);

	Flux<Campaign> findAllOrderByFirstOccurance();

	Flux<Campaign> findAllOrderByEngagements();

	Flux<Campaign> findAllOrderByLastOccurance();

	Flux<Campaign> findAllByDateFrom(Instant date);

	Flux<Campaign> findAllByDateBefore(Instant date);

}
