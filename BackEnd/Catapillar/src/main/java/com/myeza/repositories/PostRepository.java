package com.myeza.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.myeza.models.Campaign;
import com.myeza.models.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

	List<Post> findAllOrderByEndorsement();

	List<Post> findAllOrderByEngagement();

	List<Post> findAllByCreatedAtAfter(LocalDate date);

	List<Post> findAllByCreatedAtBefore(LocalDate date);

	List<Post> findAllByCreatedAtBetween(LocalDate date1, LocalDate date2);


	List<Post> findByCampaigns(Campaign campaign);
	
	

}
