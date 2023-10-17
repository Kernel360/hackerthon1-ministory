package com.example.ministory.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.example.ministory.dto.CommentDto;
import com.example.ministory.entity.Comment;
import com.example.ministory.entity.Post;
import com.example.ministory.entity.User;
import com.example.ministory.repository.CommentRepository;
import com.example.ministory.repository.PostRepository;
import com.example.ministory.repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class CommentService {
	public CommentRepository commentRepository;
	public UserRepository userRepository;
	public PostRepository postRepository;

	public void saveCommentOnPost(CommentDto commentDto, Long userId, Long postId) {
		User user = userRepository.findById(userId).orElseThrow(()-> new RuntimeException());
		Post post = postRepository.findById(postId).orElseThrow(() -> new RuntimeException());
		Comment comment = commentDto.toEntity(user, post);

		commentRepository.save(comment);
	}

	public void saveCommentOnComment(CommentDto commentDto, Long userId, Long postId, Long parentId) {
		User user = userRepository.findById(userId).orElseThrow(()-> new RuntimeException());
		Post post = postRepository.findById(postId).orElseThrow(() -> new RuntimeException());
		Comment comment = commentDto.toEntity(user, post, parentId);

		commentRepository.save(comment);
	}

	public void updateComment(Long commentId, String content) {
		Comment comment = commentRepository.findById(commentId).orElseThrow(() -> new RuntimeException());
		comment.setContent(content);
	}

	public void deleteComment(Long commentId) {
		commentRepository.deleteById(commentId);
	}
}
