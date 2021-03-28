package com.manishtech.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manishtech.backend.Dao.BlogPostRepository;
import com.manishtech.backend.model.Blog;
import org.springframework.security.core.userdetails.User;

@Service
public class BlogPostService {
	
	
	@Autowired 
	private AuthService authService;
	@Autowired
	private BlogPostRepository BlogPostRepository;
	public void createPost(Blog blog) {
	Blog post = new Blog();
	
		post.setTitle(blog.getTitle());
		User name = authService.getCurrentUser().orElseThrow(()-> new IllegalArgumentException("No new user logged in"));
		post.setName(name.getUsername());
		post.setBannerUrl(blog.getBannerUrl());
		post.setContent(blog.getContent());
		post.setDate(blog.getDate());
		post.setTime(blog.getTime());
		
		BlogPostRepository.save(post);
		
	}

	
}
