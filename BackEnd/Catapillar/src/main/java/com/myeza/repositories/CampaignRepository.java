package com.myeza.repositories;

import java.time.Instant;
import java.time.LocalDate;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.myeza.models.Campaign;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CampaignRepository extends ReactiveMongoRepository<Campaign, String> {

	Mono<Campaign> findByTagline(String name);

	Flux<Campaign> findAllOrderByFirstOccurance();

	Flux<Campaign> findAllOrderByEngagements();

	Flux<Campaign> findAllOrderByLastOccurance();

	Flux<Campaign> findAllByFirstOccuranceAfter(LocalDate date);

	Flux<Campaign> findAllByFirstOccuranceBefore(LocalDate date);

	Flux<Campaign> findAllByDuration();

}
