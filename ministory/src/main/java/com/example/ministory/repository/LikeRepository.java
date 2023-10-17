package com.example.ministory.repository;

import com.example.ministory.entity.Likes;
import com.example.ministory.entity.Post;
import com.example.ministory.entity.User;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikeRepository extends JpaRepository<Likes, Long> {

	// TODO: 여기 왜 Optional<Likes> findByUserIdAndPostId(Long userId, Long postId); 로 안되는지 알아보기
	Optional<Likes> findByUserAndPost(User userId, Post postId);

	List<Likes> findAllByUser(User user);
}
