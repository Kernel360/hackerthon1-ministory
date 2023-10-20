package com.example.ministory.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.example.ministory.dto.DeleteManyScrapDto;
import com.example.ministory.dto.ScrapDto;
import com.example.ministory.dto.ScrapPostDto;
import com.example.ministory.dto.UserIdDto;
import com.example.ministory.entity.Post;
import com.example.ministory.entity.Scrap;
import com.example.ministory.entity.User;
import com.example.ministory.exception.NotFoundException;
import com.example.ministory.repository.PostRepository;
import com.example.ministory.repository.ScrapRepository;
import com.example.ministory.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ScrapService {

	private final UserRepository userRepository;
	private final ScrapRepository scrapRepository;
	private final PostRepository postRepository;

	@Transactional
	public void addScrap(ScrapDto request) {
		User user = userRepository.findById(request.getUserId())
			.orElseThrow(() -> new NotFoundException("해당 유저가 없습니다."));
		Post post = postRepository.findById(request.getPostId())
			.orElseThrow(() -> new NotFoundException("해당 게시글이 없습니다."));
		user.addScrap(request.getUserId(), request.getPostId());

		// TODO: 이런 로직 어디에 넣어야 할지 고민해보기 1. setter를 사용하여 서비스에서 구현한다. 2. 엔티티에서 구현한다.
		post.setScrapCount(post.getScrapCount() + 1);
	}

	@Transactional
	public void deleteScrap(ScrapDto request) {
		User user = userRepository.findById(request.getUserId())
			.orElseThrow(() -> new NotFoundException("해당 유저가 없습니다."));
		Post post = postRepository.findById(request.getPostId())
			.orElseThrow(() -> new NotFoundException("해당 게시글이 없습니다."));
		post.setScrapCount(post.getScrapCount() - 1);
		Scrap scrap = scrapRepository.findByUserAndPost(user, post)
			.orElseThrow(() -> new NotFoundException("해당 스크랩이 없습니다."));
		scrapRepository.delete(scrap);
	}

	// 빨리, 효율적으로 가져오려면 어떻게 바꿀 수 있을지 고민해보기
	@Transactional
	public List<ScrapPostDto> getAllScrap(UserIdDto request) {
		User user = userRepository.findById(1l)
			.orElseThrow(() -> new NotFoundException("해당 유저가 없습니다."));
		List<Scrap> scrapList = scrapRepository.findAllByUser(user);
		List<ScrapPostDto> list = new ArrayList<>();
		for (Scrap scrap : scrapList) {
			ScrapPostDto scrapPostDto = ScrapPostDto.builder().postId(scrap.getPost().getPostId())
				.title(scrap.getPost().getTitle()).
				createdAt(scrap.getPost().getCreatedAt()).
				viewCount(scrap.getPost().getViewCount()).
				likeCount(scrap.getPost().getLikeCount()).
				scrapCount(scrap.getPost().getScrapCount()).build();
			list.add(scrapPostDto);
		}
		return list;
	}

	@Transactional
	public void deleteManyScrap(DeleteManyScrapDto request) {
		User user = userRepository.findById(request.getUserId())
			.orElseThrow(() -> new NotFoundException("해당 유저가 없습니다."));
		List<Long> postIdList = request.getPostIdList();
		for (Long postId : postIdList) {
			Post post = postRepository.findById(postId).orElseThrow(() -> new NotFoundException("해당 게시글이 없습니다."));
			post.setLikeCount(post.getLikeCount() - 1);
			Scrap scrap = scrapRepository.findByUserAndPost(user, post)
				.orElseThrow(() -> new NotFoundException("해당 스크랩이 없습니다."));
			scrapRepository.delete(scrap);
		}
	}
}
