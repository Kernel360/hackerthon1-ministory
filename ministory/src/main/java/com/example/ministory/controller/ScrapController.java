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

import com.example.ministory.dto.DeleteManyScrapDto;
import com.example.ministory.dto.ScrapDto;
import com.example.ministory.dto.ScrapPostDto;
import com.example.ministory.dto.UserIdDto;
import com.example.ministory.service.ScrapService;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/scrap")
public class ScrapController {

	private final ScrapService scrapService;

	@PostMapping("/push")
	public ResponseEntity<?> addScrap(@RequestBody @Valid ScrapDto request) {
		scrapService.addScrap(request);
		return ResponseEntity.ok().build();
	}

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
