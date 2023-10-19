package com.example.ministory.dto;

import java.sql.Timestamp;

import com.example.ministory.entity.Comment;
import com.example.ministory.entity.Post;
import com.example.ministory.entity.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommentDto {
	private Long commentId;

	private Long parentId;

	private String nickname;

	private String content;

	private Timestamp createdAt;

	private Long postId;

	public Comment toEntity(User user, Post post, Long parentId) {
		return Comment.builder()
			.user(user)
			.post(post)
			.content(content)
			.parentId(parentId)
			.build();
	}

	public Comment toEntity(User user, Post post) {
		return Comment.builder()
			.user(user)
			.post(post)
			.content(content)
			.parentId(parentId)
			.build();
	}
}
