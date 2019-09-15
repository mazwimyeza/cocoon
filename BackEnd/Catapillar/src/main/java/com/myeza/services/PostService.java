package com.myeza.services;

import java.time.Instant;
import java.time.LocalDate;

import com.myeza.models.Post;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PostService {

	Mono<Post> save(Post post);
	
	Flux<Post> findAllOrderByEndorsementDesc();
	
	Flux<Post> findAllOrderByEngagementDesc();
	
	Flux<Post> findAllByDateFrom(LocalDate date);
	
	Flux<Post> findAllByDateBefore(LocalDate date);
	
	Flux<Post> findAllByDateBetween(LocalDate date1, LocalDate date2);
	
	// TODO add aggregate functions...
}
