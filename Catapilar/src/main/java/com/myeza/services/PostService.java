package com.myeza.services;

import java.util.Date;

import com.myeza.models.Post;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PostService {

	Mono<Post> save(Post post);
	
	Flux<Post> findAllOrderByEndorsementDesc();
	
	Flux<Post> findAllOrderByEngagementDesc();
	
	Flux<Post> findAllByDateFrom(Date date);
	
	Flux<Post> findAllByDateBefore(Date date);
	
	Flux<Post> findAllByDateBetween(Date date1, Date date2);
	
	// TODO add aggregate functions...
}
