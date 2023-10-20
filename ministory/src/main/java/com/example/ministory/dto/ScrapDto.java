package com.example.ministory.dto;

import javax.validation.constraints.NotNull;

import lombok.Getter;

@Getter
public class ScrapDto {

	@NotNull(message = "유저 Id 없음")
	private Long userId;

	@NotNull(message = "게시물 Id 없음")
	private Long postId;
}
