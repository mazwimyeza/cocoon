package com.myeza.services.servicers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myeza.models.Post;
import com.myeza.repositories.PostRepository;
import com.myeza.services.PostService;

@Service
public class PostServicer implements PostService {

	@Autowired
	PostRepository postRepo;

	@Override
	public Post save(Post post) {
	
		return postRepo.save(post);
	}

	@Override
	public List<Post> findAllOrderByEndorsementDesc() {
	
		return postRepo.findAllOrderByEndorsement();
	}

	@Override
	public List<Post> findAllOrderByEngagementDesc() {
	
		return postRepo.findAllOrderByEngagement();
	}

	@Override
	public List<Post> findAllByDateFrom(LocalDate date) {
		
		return postRepo.findAllByCreatedAtAfter(date);
	}

	@Override
	public List<Post> findAllByDateBefore(LocalDate date) {
		
		return postRepo.findAllByCreatedAtBefore(date);
	}

	@Override
	public List<Post> findAllByDateBetween(LocalDate date1, LocalDate date2) {
		
		return postRepo.findAllByCreatedAtBetween(date1, date2);
	}
	
	
}
