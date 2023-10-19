package com.example.ministory.repository;

import com.example.ministory.entity.Post;
import com.example.ministory.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findAllByUser(User user);
}
