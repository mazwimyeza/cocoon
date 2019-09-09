package com.myeza.repositories;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.myeza.models.Post;

public interface PostRepository extends ReactiveMongoRepository<Post, String> {

}
