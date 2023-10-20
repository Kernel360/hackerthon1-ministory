package com.example.ministory.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.ministory.dto.CategoryDto;
import com.example.ministory.entity.Category;
import com.example.ministory.service.CategoryService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Controller
@RequestMapping("/api/category")
public class CategoryController {
	private CategoryService categoryService;

	// TODO: 유저의 카테고리를 전부 받아서 리스팅하는 함수
	@GetMapping("")
	public String getCategoryList(Model model, Long userId) {
		List<Category> categories = categoryService.findUserCategory(1L);
		model.addAttribute("categories", categories);
		return "category/categoryList";
	}

	// TODO: 카테고리를 입력하는 함수
	@PostMapping("")
	public String postCategory(CategoryDto categoryDto, Long userId) {
		categoryDto.setTitle("test");
		// TODO: 1번 유저가 생성한 카테고리로 우선 분류
		categoryService.saveCategoryOnUser(categoryDto, 1L);
		return "redirect:category";
	}

	@PostMapping("/delete")
	public String deleteCategory(Long categoryId) {
		categoryService.deleteCategory(categoryId);
		return "redirect:/api/category";
	}
}
