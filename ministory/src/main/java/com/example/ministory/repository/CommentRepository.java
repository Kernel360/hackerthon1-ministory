package com.example.ministory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ministory.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
