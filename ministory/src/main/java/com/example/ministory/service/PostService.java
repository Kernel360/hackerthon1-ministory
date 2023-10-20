package com.example.ministory.service;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

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

		Post post = new Post(categoryRepository.findById(1L).orElseThrow(() -> new RuntimeException()),
			//              TODO: userId 로 바꿔야함
			userRepository.findById(Long.valueOf(1)).orElseThrow(() -> new RuntimeException()),
			title, htmlContent, markdownContent);

		postRepository.save(post);
		return post.getPostId();
	}

	public List<Post> findUserPost(Long userId) {
		User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException());
		return postRepository.findAllByUser(user);
	}

	public String findUserName(Long userId) {
		User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException());
		return user.getNickname();
	}

	public List<Post> findAllPost() {
		return postRepository.findAll();
	}

}
