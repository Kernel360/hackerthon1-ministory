package com.example.ministory.controller;

import com.example.ministory.dto.ScrapDto;
import com.example.ministory.dto.ScrapPostDto;
import com.example.ministory.dto.UserIdDto;
import com.example.ministory.service.ScrapService;
import io.swagger.v3.oas.annotations.Operation;
import java.util.List;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/scrap")
public class ScrapController {

	private final ScrapService scrapService;

	@Operation(summary = "스크랩 누르기")
	@PostMapping("/push")
	public void addScrap(@RequestBody @Valid ScrapDto request) {
		scrapService.addScrap(request);
	}

		@Operation(summary = "스크랩 취소")
		@PostMapping("/cancel")
		public void deleteScrap(@RequestBody @Valid ScrapDto request) {
			scrapService.deleteScrap(request);
		}

		// 스크랩 모두 모아보는 API
		@PostMapping("/all")
		public List<ScrapPostDto> getAllScrap(@RequestBody @Valid UserIdDto request) {
			return scrapService.getAllScrap(request);
		}

	//	// 스크랩 여러개 선택해서 한번에 삭제하는 API
	//	@PostMapping("/all/delete")
	//	public void deleteManyLikes(@RequestBody @Valid DeleteManyLikesDto request) {
	//		scrapService.deleteManyLikes(request);
	//	}

}
