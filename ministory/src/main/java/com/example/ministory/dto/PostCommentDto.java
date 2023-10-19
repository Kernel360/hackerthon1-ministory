package com.example.ministory.dto;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PostCommentDto {
	private Long userId;
	private Long postId;
	private Long parentId;
	private String parentType;
	private String content;
}
