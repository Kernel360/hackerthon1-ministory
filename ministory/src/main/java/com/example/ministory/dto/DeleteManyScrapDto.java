package com.example.ministory.dto;

import java.util.List;
import lombok.Getter;

@Getter
public class DeleteManyScrapDto {

	private Long userId;
	private List<Long> postIdList;
}
