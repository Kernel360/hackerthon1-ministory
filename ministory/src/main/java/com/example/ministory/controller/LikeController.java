package com.example.ministory.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.ministory.dto.DeleteManyLikesDto;
import com.example.ministory.dto.LikePostDto;
import com.example.ministory.dto.LikesDto;
import com.example.ministory.dto.UserIdDto;
import com.example.ministory.service.LikeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

@Api(tags = {"좋아요 관련 API"})
@Controller
@RequiredArgsConstructor
@RequestMapping("/api/like")
public class LikeController {

	private final LikeService likeService;

	@ApiOperation(value = "좋아요 누르기")
	@PostMapping("/push")
	public ResponseEntity<?> pushLikes(@RequestBody @Valid LikesDto request) {
		likeService.pushLikes(request);
		return ResponseEntity.ok().build();
	}

	@ApiOperation(value = "좋아요 취소")
	@PostMapping("/cancel")
	public ResponseEntity<?> deleteLikes(@RequestBody @Valid LikesDto request) {
		likeService.deleteLikes(request);
		return ResponseEntity.ok().build();
	}

	// 좋아요 모두 모아보는 API
	@PostMapping("/all")
	public List<LikePostDto> getAllLikes(@RequestBody @Valid UserIdDto request) {
		return likeService.getAllLikes(request);
	}

	@ApiOperation(value = "유저에 따른 LikePostDTO 조회")
	@GetMapping("/myLikes")
	public String getAllLikes(Model model) {
		UserIdDto request = new UserIdDto();
		List<LikePostDto> list = new ArrayList<>(likeService.getAllLikes(request));
		model.addAttribute("likePostDto", list);
		return "myLikes";
	}

	// 좋아요 여러개 선택해서 한번에 삭제하는 API
	@PostMapping("/all/delete")
	public void deleteManyLikes(@RequestBody @Valid DeleteManyLikesDto request) {
		likeService.deleteManyLikes(request);
	}

}
