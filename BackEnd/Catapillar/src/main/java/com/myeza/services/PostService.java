package com.myeza.services;

import java.time.Instant;

import com.myeza.models.Post;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PostService {

	Mono<Post> save(Post post);
	
	Flux<Post> findAllOrderByEndorsementDesc();
	
	Flux<Post> findAllOrderByEngagementDesc();
	
	Flux<Post> findAllByDateFrom(Instant date);
	
	Flux<Post> findAllByDateBefore(Instant date);
	
	Flux<Post> findAllByDateBetween(Instant date1, Instant date2);
	
	// TODO add aggregate functions...
}
