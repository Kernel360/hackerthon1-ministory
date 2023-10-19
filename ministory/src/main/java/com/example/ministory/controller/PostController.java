package com.example.ministory.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.ministory.dto.LikePostDto;
import com.example.ministory.dto.PostDto;
import com.example.ministory.dto.UserDto;
import com.example.ministory.dto.UserIdDto;
import com.example.ministory.entity.User;
import com.example.ministory.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.ministory.entity.Category;
import com.example.ministory.entity.Post;
import com.example.ministory.service.PostService;
import com.google.gson.Gson;

import lombok.RequiredArgsConstructor;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostController {
	private final Long FINDED_USER_ID = Long.valueOf(1);
	@Autowired
	private PostService postService;

	@GetMapping("/view/{postId}")
	public ModelAndView viewPostForm(@PathVariable(name = "postId") Long postId, Boolean isRefresh) {
		ModelAndView mv = new ModelAndView("post/viewForm");
		Post post = postService.getPost(postId);
		if (isRefresh == null || !isRefresh)
			postService.addViewCount(postId);
		mv.addObject("post", post);
		return mv;
	}

	@GetMapping("/view/refresh/{postId}")
	public ModelAndView refreshViewPostForm(@PathVariable(name = "postId") Long postId) {
		ModelAndView mv = new ModelAndView("post/viewForm");
		Post post = postService.getPost(postId);
		mv.addObject("post", post);
		return mv;
	}

	@GetMapping("/write")
	public ModelAndView showWriteForm() {
		// todo: 세션 정보 확인 필요.
		ModelAndView mv = new ModelAndView("post/writeForm");
		List<Category> categories = postService.findUserCategory(FINDED_USER_ID);
		mv.addObject("categories", categories);
		return mv;
	}

	@PostMapping("/write")
	public Long writePost(@RequestBody String postData) {
		// todo: writeForm이 아닌 viewForm 으로 리디렉션
		// todo: 작성자 정보 (세션 정보 넣을 것)
		Long postId = null;

		try {
			Gson gson = new Gson();
			Map<Object, Object> map = new HashMap<Object, Object>();
			System.out.println(postData);
			map = (Map<Object, Object>)gson.fromJson(postData, map.getClass());

			postId = postService.writePost(map);
			System.out.println("postId: " + postId);

		} catch (Exception e) {
			e.printStackTrace();
		}
		// return json;
		return postId;
	}

//	@ApiOperation(value = "내 블로그(Category/Post) 조회")
//	@PostMapping("/myBlog")
//	public String getPost(@RequestBody @Valid UserIdDto request, Model model) {
//		List<Post> list = new ArrayList<>(postService.getPostByUserId(request));
//		List<Category> list2 = new ArrayList<>(postService.findUserCategory(request.getUserId()));
//		model.addAttribute("posts", list);
//		model.addAttribute("categories", list2);
//		return "myBlog";
//	}

	@ApiOperation(value = "내 블로그(Category/Post) 조회")
	@GetMapping("/myBlog/{userId}")
	public ModelAndView viewPostForm(@PathVariable(name = "userId") Long userId) {
		ModelAndView mv = new ModelAndView("myBlog");
		List<Post> list = new ArrayList<>(postService.findUserPost(userId));
		List<Category> list2 = new ArrayList<>(postService.findUserCategory(userId));
		String userName = new String(postService.findUserName(userId));
		mv.addObject("posts", list);
		mv.addObject("categories", list2);
		mv.addObject("currentUser", userName);
		return mv;
	}
}
