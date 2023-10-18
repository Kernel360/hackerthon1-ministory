package com.example.ministory.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import com.example.ministory.dto.PostDto;
import com.example.ministory.dto.UserIdDto;
import com.example.ministory.exception.NotFoundException;
import org.springframework.stereotype.Service;

import com.example.ministory.entity.Category;
import com.example.ministory.entity.Post;
import com.example.ministory.entity.User;
import com.example.ministory.repository.CategoryRepository;
import com.example.ministory.repository.PostRepository;
import com.example.ministory.repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class PostService {
	private final UserRepository userRepository;
	private final CategoryRepository categoryRepository;
	private final PostRepository postRepository;

	public Post getPost(Long postId) {
		// todo: 멘토링 시 포스트 view 를 위해 post 객체를 select 하는 부분과
		//  view count 를 +1 업데이트 하는 부분의 로직을 나눠야 할지, 합쳐야 할지 질문해야함!
		return postRepository.findById(postId).orElseThrow(() -> new RuntimeException());
	}

	public void addViewCount(Long postId) {
		Post post = postRepository.findById(postId).get();
		post.setViewCount(post.getViewCount() + 1);
		postRepository.save(post);
	}

	public List<Category> findUserCategory(Long userId) {
		User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException());
		return categoryRepository.findCategoriesByUser(user);
	}

	public Long writePost(Map<Object, Object> map) {
		String title = (String)map.get("title");
		Long categoryId = Long.parseLong((String)map.get("category_id"));
		String markdownContent = (String)map.get("content_md");
		String htmlContent = (String)map.get("content_html");

		// Post post = new Post(categoryRepository.findById(categoryId).orElseThrow(() -> new RuntimeException()),
		Post post = new Post(categoryRepository.findById(1L).orElseThrow(() -> new RuntimeException()),
			//              TODO: userId 로 바꿔야함
			userRepository.findById(Long.valueOf(1)).orElseThrow(() -> new RuntimeException()),
			title, htmlContent, markdownContent);

		postRepository.save(post);
		return post.getPostId();
	}

	@Transactional
	public List<Post> getPostByUserId(UserIdDto request) {
		User user = userRepository.findById(request.getUserId())
				.orElseThrow(() -> new NotFoundException("해당 유저가 없습니다."));
		List<Post> postList = postRepository.findAllByUser(user);
		return postList;
	}

}
