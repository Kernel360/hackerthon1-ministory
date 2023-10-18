package com.example.ministory.service;

import com.example.ministory.dto.DeleteManyLikesDto;
import com.example.ministory.dto.LikePostDto;
import com.example.ministory.dto.LikesDto;
import com.example.ministory.dto.UserIdDto;
import com.example.ministory.entity.Likes;
import com.example.ministory.entity.Post;
import com.example.ministory.entity.User;
import com.example.ministory.repository.LikeRepository;
import com.example.ministory.repository.PostRepository;
import com.example.ministory.repository.UserRepository;
import java.sql.Timestamp;
import java.util.ArrayList;
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
		Post post = postRepository.findById(request.getPostId()).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다."));
		user.addLikes(request.getUserId(), request.getPostId());

		// TODO: 이런 로직 어디에 넣어야 할지 고민해보기 1. setter를 사용하여 서비스에서 구현한다. 2. 엔티티에서 구현한다.
		post.setLikeCount(post.getLikeCount() + 1);
	}

	@Transactional
	public void deleteLikes(LikesDto request) {
		User user = userRepository.findById(request.getUserId()).orElseThrow(() -> new IllegalArgumentException("해당 유저가 없습니다."));
		Post post = postRepository.findById(request.getPostId()).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다."));
		post.setLikeCount(post.getLikeCount() - 1);
		Likes likes = likeRepository.findByUserAndPost(user, post).orElseThrow(() -> new IllegalArgumentException("해당 좋아요가 없습니다."));
		likeRepository.delete(likes);
	}

	// 여기 쿼리 진짜 비효율적임. 더 빨리, 효율적으로 가져오려면 어떻게 바꿀 수 있을지 고민해보기
	@Transactional
	public List<LikePostDto> getAllLikes(UserIdDto request) {
		 User user = userRepository.findById(request.getUserId()).orElseThrow(() -> new IllegalArgumentException("해당 유저가 없습니다."));
		 // TODO: 이거 user안에 있는 likeList 가져다가 쓰면 안돼나?
		List<Likes> likesList = likeRepository.findAllByUser(user);
		List<LikePostDto> list = new ArrayList<>();
		for (Likes like : likesList) {
			LikePostDto likePostDto = LikePostDto.builder().postId(like.getPost().getPostId())
							.title(like.getPost().getTitle()).
							createdAt(like.getPost().getCreatedAt()).
							viewCount(like.getPost().getViewCount()).
							likeCount(like.getPost().getLikeCount()).
							scrapCount(like.getPost().getScrapCount()).build();
			list.add(likePostDto);
		}
		return list;
	}

	@Transactional
	public void deleteManyLikes(DeleteManyLikesDto request) {
		User user = userRepository.findById(request.getUserId()).orElseThrow(() -> new IllegalArgumentException("해당 유저가 없습니다."));
		List<Long> postIdList = request.getPostIdList();
		for (Long postId : postIdList) {
			Post post = postRepository.findById(postId).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다."));
			post.setLikeCount(post.getLikeCount() - 1);
			Likes likes = likeRepository.findByUserAndPost(user, post).orElseThrow(() -> new IllegalArgumentException("해당 좋아요가 없습니다."));
			likeRepository.delete(likes);
		}
	}
}
