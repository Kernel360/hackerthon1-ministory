package com.example.ministory.controller;

import com.example.ministory.dto.deleteLikesDto;
import com.example.ministory.dto.pushLikesDto;
import com.example.ministory.service.LikeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Tag(name = "좋아요 관련 API")
@Controller
@RequiredArgsConstructor
@RequestMapping("/api/like")
public class LikeController {

	private final LikeService likeService;

	@Operation(summary = "좋아요 누르기")
	@PostMapping("/push")
	public void pushLikesButton(@RequestBody @Valid pushLikesDto request) {
		likeService.pushLikesButton(request);
	}

	@Operation(summary = "좋아요 취소")
	@PostMapping("/cancel")
	public void deleteLikesButton(@RequestBody @Valid deleteLikesDto request) {
		likeService.deleteLikesButton();
	}

}
