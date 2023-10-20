package com.example.ministory.dto;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

@ApiModel(value = "성장 일기 내용 기록")
@Getter
public class LikesDto {

	@ApiModelProperty(value = "사용자 ID", example = "2", required = true)
	@NotNull(message = "유저 Id 없음")
	private Long userId;

	@ApiModelProperty(value = "게시물 ID", example = "3", required = true)
	@NotNull(message = "게시물 Id 없음")
	private Long postId;
}
