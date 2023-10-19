package com.example.ministory.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.ministory.dto.CommentDto;
import com.example.ministory.dto.PostCommentDto;
import com.example.ministory.entity.Comment;
import com.example.ministory.service.CommentService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
@RequestMapping("/api/comment")
// todo:임시 맵핑입니다 추후에 게시글(Post)랑 붙여서 이어주셔야 합니다.
public class CommentController {
	private final CommentService commentService;

	@GetMapping("/write")
	public String getCommentWriteForm(CommentDto commentDto) {
		// todo : 지금은 임시 페이지에서 댓글 달 수 있도록 되어 있고 추후 수정이 필요합니다.
		return "test/commentWriteTest";
	}

	@PostMapping("/write")
	public ResponseEntity<?> postCommentWriteForm(@RequestBody PostCommentDto postCommentDto) {
		// final long TEST_USER_ID = 1L;
		// final long TEST_POST_ID = 1L;
		System.out.println("here");
		System.out.println(postCommentDto.toString());
		if (postCommentDto.getParentId() == null) {
			System.out.println("post comment");
			commentService.saveCommentOnPost(postCommentDto);
		} else /*if (postCommentDto.getParentType().equals("comment")) */ {
			commentService.saveCommentOnComment(postCommentDto);
		}
		// else {
		// 	throw new ConflictException("유효하지 않은 parentType 입니다.");
		// }
		System.out.println("fin");
		return ResponseEntity.ok().build();
	}

	// @PostMapping("/write")
	// public String postCommentWriteForm(Object parent, CommentDto commentDto, Long userId, Long postId) {
	// 	final long TEST_USER_ID = 1L;
	// 	final long TEST_POST_ID = 1L;
	// 	if (parent.getClass().equals(Post.class)) {
	// 		commentService.saveCommentOnPost(commentDto, userId, postId);
	// 	} else {
	// 		commentService.saveCommentOnComment(commentDto, userId, postId, ((Comment)parent).getCommentId());
	// 	}
	//
	// 	return "redirect:/";
	// }

	@GetMapping("/view")
	public String getCommentViewForm(Model model, Long userId, Long postId) {
		final long TEST_USER_ID = 1L;
		final long TEST_POST_ID = 1L;
		List<Comment> comments = commentService.findAllComments(userId, postId);
		model.addAttribute("comments", comments);
		// todo: 임시 페이지입니다. 새로운 템플릿 필요.
		return "test/commentViewTest";
	}
}
