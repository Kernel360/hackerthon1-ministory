package com.example.ministory.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.ministory.dto.CategoryDto;
import com.example.ministory.dto.UserDto;
import com.example.ministory.entity.Category;
import com.example.ministory.entity.User;
import com.example.ministory.service.CategoryService;
import com.example.ministory.service.UserService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Controller
@RequestMapping("/api/user")
public class UserController {
	private UserService userService;

	private CategoryService categoryService;

	@GetMapping("/signup")
	public String getSignUp(UserDto userDto) {
		return "userCreateForm";
	}

	@PostMapping("/signup")
	public String postSignUp(@Valid UserDto userDto, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "userCreateForm";
		}
		userService.saveUser(userDto);
		return "redirect:mypage";
	}

	@GetMapping("/list")
	public String getUserList(Model model) {
		List<User> users = userService.findUsers();
		model.addAttribute("users", users);
		return "userlist";
	}

	@GetMapping("/mypage")
	public String getMyPage(Model model) {
		List<Category> categories = categoryService.findUserCategory(1L);
		model.addAttribute("categories", categories);
		return "mypage";
	}

	@PostMapping("/mypage/category")
	public String postCategory(CategoryDto categoryDto, Long userId) {
		categoryDto.setTitle("test");
		// TODO: 1번 유저가 생성한 카테고리로 우선 분류
		categoryService.saveCategoryOnUser(categoryDto, 1L);
		return "redirect:/api/user/mypage";
	}

	@PostMapping("/mypage/category/delete")
	public String deleteCategoryMyPage(Long categoryId) {
		categoryService.deleteCategory(categoryId);
		return "redirect:/api/user/mypage";
	}
}
