package com.manishtech.backend.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.manishtech.backend.model.Blog;

public interface BlogPostRepository extends JpaRepository<Blog, Long> {

}
