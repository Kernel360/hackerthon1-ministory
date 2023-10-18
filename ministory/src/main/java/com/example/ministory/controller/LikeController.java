package com.example.ministory.controller;

import com.example.ministory.dto.DeleteManyLikesDto;
import com.example.ministory.dto.LikePostDto;
import com.example.ministory.dto.LikesDto;
import com.example.ministory.dto.UserIdDto;
import com.example.ministory.service.LikeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
//import io.swagger.v3.oas.annotations.Operation;
//import io.swagger.v3.oas.annotations.responses.ApiResponses;
//import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

//@Tag(name = "좋아요 관련 API")
@Api(tags = {"좋아요 관련 API"})
@Controller
@RequiredArgsConstructor
@RequestMapping("/api/like")
public class LikeController {

	private final LikeService likeService;

//	@Operation(summary = "좋아요 누르기")
	@ApiOperation(value = "좋아요 누르기")
	@PostMapping("/push")
	public void pushLikes(@RequestBody @Valid LikesDto request) {
		likeService.pushLikes(request);
	}

//	@Operation(summary = "좋아요 취소")
	@ApiOperation(value = "좋아요 취소")
	@PostMapping("/cancel")
	public void deleteLikes(@RequestBody @Valid LikesDto request) {
		likeService.deleteLikes(request);
	}

	// 좋아요 모두 모아보는 API
	@PostMapping("/all")
	public List<LikePostDto> getAllLikes(@RequestBody @Valid UserIdDto request) {
		return likeService.getAllLikes(request);
	}

	@ApiOperation(value = "유저에 따른 LikePostDTO 조회")
	@PostMapping("/myLikes")
	public String getAllLikes(@RequestBody @Valid UserIdDto request, Model model) {
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
