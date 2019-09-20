package com.myeza.services;

import java.time.LocalDate;
import java.util.List;

import com.myeza.models.Post;

public interface PostService {

	Post save(Post post);

	List<Post> findAllOrderByEndorsementDesc();

	List<Post> findAllOrderByEngagementDesc();

	List<Post> findAllByDateFrom(LocalDate date);

	List<Post> findAllByDateBefore(LocalDate date);

	List<Post> findAllByDateBetween(LocalDate date1, LocalDate date2);

	// TODO add aggregate functions...
}
