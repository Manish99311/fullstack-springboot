package com.manishtech.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manishtech.backend.model.Blog;
import com.manishtech.backend.service.BlogPostService;

@RestController
@RequestMapping("/api/posts/")
public class BlogPostController {
	
	@Autowired
	private BlogPostService blogPostService;
	
	@PostMapping()
	public ResponseEntity createPost(@RequestBody Blog blog ) {
		blogPostService.createPost(blog);
		return new ResponseEntity(HttpStatus.OK);
	}

}
