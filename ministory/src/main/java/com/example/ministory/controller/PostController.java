package com.example.ministory.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostController {
    @GetMapping("/write")
    public ModelAndView showWriteForm() {
        // todo: 세션 정보 확인 필요.
        ModelAndView mv = new ModelAndView("post/writeForm");
        return mv;
    }


}
