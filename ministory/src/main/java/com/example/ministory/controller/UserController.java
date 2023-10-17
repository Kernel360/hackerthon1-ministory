package com.example.ministory.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.ministory.dto.UserDto;
import com.example.ministory.service.UserService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Controller
@RequestMapping("/user")
public class UserController {
    private UserService userService;

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
        return "redirect:/";
    }

    @GetMapping("/list")
    public String getUserList(Model model) {
        List<User> users = userService.findUsers();
        model.addAttribute("users", users);
        return "userlist";
    }
}
