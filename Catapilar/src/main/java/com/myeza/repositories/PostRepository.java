package com.myeza.repositories;

import java.util.Date;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.myeza.models.Post;

import reactor.core.publisher.Flux;

public interface PostRepository extends ReactiveMongoRepository<Post, String> {

	Flux<Post> findAllOrderByEndorsementDesc();

	Flux<Post> findAllOrderByEngagementDesc();

	Flux<Post> findAllByDateFrom(Date date);

	Flux<Post> findAllByDateBefore(Date date);

	Flux<Post> findAllByDateBetween(Date date1, Date date2);


}
