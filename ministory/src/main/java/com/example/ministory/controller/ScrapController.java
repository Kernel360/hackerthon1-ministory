package com.example.ministory.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import com.example.ministory.dto.*;
import com.example.ministory.entity.User;
import com.example.ministory.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.ministory.service.ScrapService;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/scrap")
public class ScrapController {

	private final ScrapService scrapService;

	//	@Operation(summary = "스크랩 누르기")
	@PostMapping("/push")
	public ResponseEntity<?> addScrap(@RequestBody @Valid ScrapDto request) {
		scrapService.addScrap(request);
		return ResponseEntity.ok().build();
	}

	//		@Operation(summary = "스크랩 취소")
	@PostMapping("/cancel")
	public ResponseEntity<?> deleteScrap(@RequestBody @Valid ScrapDto request) {
		scrapService.deleteScrap(request);
		return ResponseEntity.ok().build();
	}

	// 스크랩 모두 모아보는 API
	@PostMapping("/all")
	public List<ScrapPostDto> getAllScrap(@RequestBody @Valid UserIdDto request) {
		return scrapService.getAllScrap(request);
	}

	// 스크랩 여러개 선택해서 한번에 삭제하는 API
	@PostMapping("/all/delete")
	public void deleteManyScrap(@RequestBody @Valid DeleteManyScrapDto request) {
		scrapService.deleteManyScrap(request);
	}

	@ApiOperation(value = "유저에 따른 ScrapPostDTO 조회")
	@GetMapping("/myScraps")
	public String getAllScrap(Model model) {
		UserIdDto request = new UserIdDto();
		List<ScrapPostDto> list = new ArrayList<>(scrapService.getAllScrap(request));
		model.addAttribute("scrapPostDto", list);
		return "myScraps";
	}
}
