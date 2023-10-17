package com.example.ministory.dto;

import java.sql.Timestamp;
import lombok.Builder;
import lombok.Getter;

	@Getter
	@Builder
public class ScrapPostDto {

		private Long postId;
		private String title;
		private Timestamp createdAt;
		private Long viewCount;
		private Long likeCount;
		private Long scrapCount;
}
