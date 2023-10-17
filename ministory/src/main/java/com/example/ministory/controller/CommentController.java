package com.example.ministory.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.ministory.dto.CommentDto;
import com.example.ministory.entity.Post;
import com.example.ministory.service.CommentService;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
@RequestMapping("/comment")
// todo:임시 맵핑입니다 추후에 게시글(Post)랑 붙여서 이어주셔야 합니다.
public class CommentController {
	private final CommentService commentService;

	@GetMapping("/write")
	public String getCommentForm(Object parent, CommentDto commentDto, Long userId) {
		if (parent.getClass().equals(Post.class)) {
			commentService.saveCommentOnPost();
		} else {

		}
	}
}
