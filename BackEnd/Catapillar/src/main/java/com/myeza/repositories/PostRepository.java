package com.myeza.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.myeza.models.Post;

public interface PostRepository extends MongoRepository<Post, String> {

	List<Post> findAllOrderByEndorsement();

	List<Post> findAllOrderByEngagement();

	List<Post> findAllByCreatedAtAfter(LocalDate date);

	List<Post> findAllByCreatedAtBefore(LocalDate date);

	List<Post> findAllByCreatedAtBetween(LocalDate date1, LocalDate date2);

}
