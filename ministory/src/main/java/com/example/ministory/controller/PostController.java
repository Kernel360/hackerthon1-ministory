package com.example.ministory.controller;

import com.example.ministory.dto.PostDto;
import com.example.ministory.entity.Category;
import com.example.ministory.service.PostService;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostController {
    @Autowired
    private PostService postService;
    @GetMapping("/write")
    public ModelAndView showWriteForm() {
        // todo: 세션 정보 확인 필요.
        final Long FINDED_USER_ID = Long.valueOf(1);
        ModelAndView mv = new ModelAndView("post/writeForm");
        List<Category> categories = postService.findUserCategory(FINDED_USER_ID);
        mv.addObject("categories", categories);
        return mv;
    }

    @PostMapping("/write")
    public ModelAndView writePost(RequestBody requestBody, BindingResult bindingResult) {

        // todo: writeForm이 아닌 viewForm 으로 리디렉션
        if (bindingResult.hasErrors()) {
            return new ModelAndView("post/writeForm");
        }

        return new ModelAndView("redirect:/");
    }

}
