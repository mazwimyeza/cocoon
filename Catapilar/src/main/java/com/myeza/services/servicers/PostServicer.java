package com.myeza.services.servicers;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.myeza.models.Post;
import com.myeza.repositories.PostRepository;
import com.myeza.services.PostService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class PostServicer implements PostService {

	@Autowired
	PostRepository postRepo;

	@Override
	public Mono<Post> save(Post post) {
	
		return postRepo.save(post);
	}

	@Override
	public Flux<Post> findAllOrderByEndorsementDesc() {
	
		return postRepo.findAllOrderByEndorsementDesc();
	}

	@Override
	public Flux<Post> findAllOrderByEngagementDesc() {
	
		return postRepo.findAllOrderByEngagementDesc();
	}

	@Override
	public Flux<Post> findAllByDateFrom(Date date) {
		
		return postRepo.findAllByDateFrom(date);
	}

	@Override
	public Flux<Post> findAllByDateBefore(Date date) {
		
		return postRepo.findAllByDateBefore(date);
	}

	@Override
	public Flux<Post> findAllByDateBetween(Date date1, Date date2) {
		
		return postRepo.findAllByDateBetween(date1, date2);
	}
	
	
}
