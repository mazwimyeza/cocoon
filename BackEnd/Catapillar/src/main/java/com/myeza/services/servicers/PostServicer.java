package com.myeza.services.servicers;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myeza.models.Post;
import com.myeza.repositories.PostRepository;
import com.myeza.services.PostService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PostServicer implements PostService {

	@Autowired
	PostRepository postRepo;

	@Override
	public Mono<Post> save(Post post) {
	
		return postRepo.save(post);
	}

	@Override
	public Flux<Post> findAllOrderByEndorsementDesc() {
	
		return postRepo.findAllOrderByEndorsement();
	}

	@Override
	public Flux<Post> findAllOrderByEngagementDesc() {
	
		return postRepo.findAllOrderByEngagement();
	}

	@Override
	public Flux<Post> findAllByDateFrom(LocalDate date) {
		
		return postRepo.findAllByCreatedAtAfter(date);
	}

	@Override
	public Flux<Post> findAllByDateBefore(LocalDate date) {
		
		return postRepo.findAllByCreatedAtBefore(date);
	}

	@Override
	public Flux<Post> findAllByDateBetween(LocalDate date1, LocalDate date2) {
		
		return postRepo.findAllByCreatedAtBetween(date1, date2);
	}
	
	
}
