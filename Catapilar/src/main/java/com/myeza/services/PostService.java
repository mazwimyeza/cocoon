package com.myeza.services;

import java.util.Date;
import java.util.List;

import com.myeza.models.Campaign;
import com.myeza.models.Post;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PostService {

	Mono<Post> save(Post post);
	
	Flux<Post> getPostsByEndorsement();
	
	Flux<Post> getPostsByEngagement();
	
	Flux<Post> getPostsFromDate(Date date);
	
	Flux<Post> getPostBeforeDate(Date date);
	
	// TODO add aggregate functions...
}
