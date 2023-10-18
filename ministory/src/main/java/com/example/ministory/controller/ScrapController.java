package com.example.ministory.controller;

import com.example.ministory.dto.*;
import com.example.ministory.service.ScrapService;
//import io.swagger.v3.oas.annotations.Operation;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/scrap")
public class ScrapController {

	private final ScrapService scrapService;

//	@Operation(summary = "스크랩 누르기")
	@PostMapping("/push")
	public void addScrap(@RequestBody @Valid ScrapDto request) {
		scrapService.addScrap(request);
	}

//		@Operation(summary = "스크랩 취소")
		@PostMapping("/cancel")
		public void deleteScrap(@RequestBody @Valid ScrapDto request) {
			scrapService.deleteScrap(request);
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
	@PostMapping("/myScraps")
	public String getAllScrap(@RequestBody @Valid UserIdDto request, Model model) {
		List<ScrapPostDto> list = new ArrayList<>(scrapService.getAllScrap(request));
		model.addAttribute("scrapPostDto", list);
		return "myScraps";
	}

}
