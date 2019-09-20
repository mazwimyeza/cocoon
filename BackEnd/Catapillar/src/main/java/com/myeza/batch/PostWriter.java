package com.myeza.batch;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

import com.myeza.models.Post;
import com.myeza.services.PostService;

public class PostWriter implements ItemWriter<Post> {

	@Autowired
	PostService postService;
	
	@Override
	public void write(List<? extends Post> items) throws Exception {
		
		for(Post post : items) {
			if(post != null)
				postService.save(post);
		}

	}

}
