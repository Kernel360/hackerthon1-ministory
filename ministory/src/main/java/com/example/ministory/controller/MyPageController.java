package com.example.ministory.controller;

import java.util.List;

import javax.validation.Valid;

import com.example.ministory.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.ministory.dto.UserDto;
import com.example.ministory.entity.User;
import com.example.ministory.service.UserService;

import lombok.AllArgsConstructor;

/*

@AllArgsConstructor
@Controller
@RequestMapping("api")
public class MyPageController {
    @GetMapping("/mypage")
    public String getMyPage() {
        return "mypage";
    }
}

 */
