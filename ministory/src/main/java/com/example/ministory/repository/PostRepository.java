package com.example.ministory.repository;

import com.example.ministory.entity.PostEntity;
import com.example.ministory.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<PostEntity, Long> {
}
