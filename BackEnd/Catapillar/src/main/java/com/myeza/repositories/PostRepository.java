package com.myeza.repositories;

import java.time.Instant;
import java.time.LocalDate;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.myeza.models.Post;

import reactor.core.publisher.Flux;

public interface PostRepository extends ReactiveMongoRepository<Post, String> {

	Flux<Post> findAllOrderByEndorsement();

	Flux<Post> findAllOrderByEngagement();

	Flux<Post> findAllByCreatedAtAfter(LocalDate date);

	Flux<Post> findAllByCreatedAtBefore(LocalDate date);

	Flux<Post> findAllByCreatedAtBetween(LocalDate date1, LocalDate date2);


}
