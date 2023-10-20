package com.example.ministory.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.ministory.dto.CommentDto;
import com.example.ministory.dto.PostCommentDto;
import com.example.ministory.service.CommentService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
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
		System.out.println("here");
		System.out.println(postCommentDto.toString());
		if (postCommentDto.getParentId() == null) {
			System.out.println("post comment");
			commentService.saveCommentOnPost(postCommentDto);
		} else {
			commentService.saveCommentOnComment(postCommentDto);
		}
		System.out.println("fin");
		return ResponseEntity.ok().build();
	}

	@ApiOperation(value = "댓글 리스트 조회", notes = "댓글 조회")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "postId", required = true, dataType = "Long", paramType = "path", defaultValue = "1"),
	})
	@GetMapping("/view/{postId}")
	public ResponseEntity<List<CommentDto>> getCommentViewForm(@PathVariable(name = "postId") Long postId) {

		List<CommentDto> commentDtoList = commentService.findAllComments(postId);
		return new ResponseEntity<>(commentDtoList, HttpStatus.OK);
	}
}
