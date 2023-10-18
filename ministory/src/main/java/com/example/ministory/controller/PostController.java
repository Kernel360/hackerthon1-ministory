package com.example.ministory.controller;

import com.example.ministory.dto.PostDto;
import com.example.ministory.entity.Category;
import com.example.ministory.entity.Post;
import com.example.ministory.service.PostService;
import com.google.gson.Gson;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostController {
    @Autowired
    private PostService postService;

    private final Long FINDED_USER_ID = Long.valueOf(1);

    @GetMapping("/view/{postId}")
    public ModelAndView viewPostForm(@PathVariable(name = "postId") Long postId) {
        ModelAndView mv = new ModelAndView("post/viewForm");
        Post post = postService.getPost(postId);
        postService.addViewCount(postId);
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
    public String writePost(@RequestBody String postData) {
        // todo: writeForm이 아닌 viewForm 으로 리디렉션
        // todo: 작성자 정보 (세션 정보 넣을 것)
        String json = null;

        try {
            Gson gson = new Gson();
            Map<Object, Object> map = new HashMap<Object, Object>();
            map = (Map<Object, Object>)gson.fromJson(postData, map.getClass());

            postService.writePost(map);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return json;
    }

}
