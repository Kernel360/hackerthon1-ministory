package com.example.ministory.dto;

import java.util.List;
import lombok.Getter;

@Getter
public class DeleteManyLikesDto {

	private Long userId;
	private List<Long> postIdList;
}
