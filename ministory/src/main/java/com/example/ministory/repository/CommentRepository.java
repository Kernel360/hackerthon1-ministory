package com.example.ministory.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ministory.entity.Comment;
import com.example.ministory.entity.Post;
import com.example.ministory.entity.User;

public interface CommentRepository extends JpaRepository<Comment, Long> {
	List<Comment> findCommentsByUserAndPost(User user, Post post);
}
