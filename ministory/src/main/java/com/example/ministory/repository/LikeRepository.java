package com.example.ministory.repository;

import com.example.ministory.entity.Likes;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikeRepository extends JpaRepository<Likes, Long> {

	Optional<Likes> findByUserIdAndPostId(Long userId, Long postId);
}
