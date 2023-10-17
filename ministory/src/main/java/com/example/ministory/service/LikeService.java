package com.example.ministory.service;

import com.example.ministory.dto.LikesDto;
import com.example.ministory.entity.Likes;
import com.example.ministory.entity.Post;
import com.example.ministory.entity.User;
import com.example.ministory.repository.LikeRepository;
import com.example.ministory.repository.PostRepository;
import com.example.ministory.repository.UserRepository;
import java.util.List;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LikeService {

	private final UserRepository userRepository;
	private final LikeRepository likeRepository;
	private final PostRepository postRepository;

 	@Transactional
	public void pushLikes(LikesDto request) {
		User user = userRepository.findById(request.getUserId()).orElseThrow(() -> new IllegalArgumentException("해당 유저가 없습니다."));
		user.addLikes(request.getUserId(), request.getPostId());
	}

	@Transactional
	public void deleteLikes(LikesDto request) {
		User user = userRepository.findById(request.getUserId()).orElseThrow(() -> new IllegalArgumentException("해당 유저가 없습니다."));
		Post post = postRepository.findById(request.getPostId()).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다."));
		Likes likes = likeRepository.findByUserAndPost(user, post).orElseThrow(() -> new IllegalArgumentException("해당 좋아요가 없습니다."));

		likeRepository.delete(likes);
	}
}
