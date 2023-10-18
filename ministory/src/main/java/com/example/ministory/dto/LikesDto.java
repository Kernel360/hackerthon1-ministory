package com.example.ministory.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class LikesDto {

	@Schema(example = "2")
	@NotNull(message = "유저 Id 없음")
	private Long userId;

	@Schema(example = "3")
	@NotNull(message = "게시물 Id 없음")
	private Long postId;
}
