package com.myeza.repositories;

import java.time.Instant;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.myeza.models.Post;

import reactor.core.publisher.Flux;

public interface PostRepository extends ReactiveMongoRepository<Post, String> {

	Flux<Post> findAllOrderByEndorsementDesc();

	Flux<Post> findAllOrderByEngagementDesc();

	Flux<Post> findAllByDateFrom(Instant date);

	Flux<Post> findAllByDateBefore(Instant date);

	Flux<Post> findAllByDateBetween(Instant date1, Instant date2);


}
