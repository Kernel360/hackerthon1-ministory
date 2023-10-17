package com.example.ministory.controller;

import static org.springframework.data.jpa.domain.AbstractPersistable_.*;

import java.util.List;

import javax.validation.Valid;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.ministory.dto.CategoryDto;
import com.example.ministory.entity.Category;
import com.example.ministory.service.CategoryService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
@RequestMapping("/category")
public class CategoryController {
	private final CategoryService categoryService;

	@GetMapping("/category")
	public String findCategoryList(Model model) {
		List<Category> categories = categoryService.findCategory();
		model.addAttribute("categorylist", categories);
		return ;
	}

	@PostMapping("/category")
	public String createCategory(@Valid CategoryDto categoryDto) {
		CategoryService.saveCategory(categoryDto);
		return ;
	}

	@DeleteMapping("/category")
	public Category deleteCategory(CategoryDto categoryDto) {
		CategoryService.deleteCategory(id);
		return ;
	}
}
