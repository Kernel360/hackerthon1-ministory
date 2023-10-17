package com.example.ministory.dto;

import com.example.ministory.entity.Comment;
import com.example.ministory.entity.Post;
import com.example.ministory.entity.User;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class CommentDto {
	private Long commentId;

	private String content;

	public Comment toEntity(User user, Post post, Long parentId) {
		return Comment.builder()
			.commentId(commentId)
			.user(user)
			.post(post)
			.content(content)
			.parentId(parentId)
			.build();
	}

	public Comment toEntity(User user, Post post) {
		return Comment.builder()
			.commentId(commentId)
			.user(user)
			.post(post)
			.content(content)
			.parentId(commentId)
			.build();
	}
}
