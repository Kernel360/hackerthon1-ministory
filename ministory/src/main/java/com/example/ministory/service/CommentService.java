package com.example.ministory.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.example.ministory.dto.CommentDto;
import com.example.ministory.dto.PostCommentDto;
import com.example.ministory.entity.Comment;
import com.example.ministory.entity.Post;
import com.example.ministory.entity.User;
import com.example.ministory.exception.NotFoundException;
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

	public List<CommentDto> findAllComments(Long postId) {
		Post post = postRepository.findById(postId).orElseThrow(() -> new NotFoundException("존재하지 않는 게시글입니다."));

		List<Comment> commentList = commentRepository.findAllByPost(post);
		return commentList.stream().map(c -> {
			return CommentDto.builder()
				.commentId(c.getCommentId())
				.parentId(c.getParentId())
				.nickname(c.getUser().getNickname())
				.content(c.getContent())
				.createdAt(c.getCreatedAt())
				.postId(c.getPost().getPostId())
				.build();
		}).collect(Collectors.toList());
	}

	//TODO: 여기 댓글이랑 대ㅐ댓글이랑 로직 똑같아서 나눌 필요 없음.
	public void saveCommentOnPost(PostCommentDto postCommentDto) {
		User user = userRepository.findById(postCommentDto.getUserId())
			.orElseThrow(() -> new NotFoundException("존재하지 않는 유저입니다."));
		Post post = postRepository.findById(postCommentDto.getPostId())
			.orElseThrow(() -> new NotFoundException("존재하지 않는 게시글입니다."));
		Comment comment = Comment.builder()
			.user(user)
			.post(post)
			.parentId(postCommentDto.getParentId())
			.content(postCommentDto.getContent())
			.build();
		commentRepository.save(comment);
	}

	public void saveCommentOnComment(PostCommentDto postCommentDto) {
		User user = userRepository.findById(postCommentDto.getUserId())
			.orElseThrow(() -> new NotFoundException("존재하지 않는 유저입니다."));
		Post post = postRepository.findById(postCommentDto.getPostId())
			.orElseThrow(() -> new NotFoundException("존재하지 않는 게시글입니다."));
		commentRepository.save(Comment.builder()
			.user(user)
			.post(post)
			.content(postCommentDto.getContent())
			.parentId(postCommentDto.getParentId())
			.build());
	}

	public void updateComment(Long commentId, String content) {
		Comment comment = commentRepository.findById(commentId)
			.orElseThrow(() -> new NotFoundException("존재하지 않는 댓글입니다."));
		comment.setContent(content);
	}

	public void deleteComment(Long commentId) {
		commentRepository.deleteById(commentId);
	}
}
