package com.example.ministory.controller;

import com.example.ministory.entity.User;
import com.example.ministory.repository.UserRepository;
import com.example.ministory.dto.UserEntityDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/api/user")
public class UserApiController {

    private final UserRepository userRepository;

    @GetMapping("/find-all")
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @GetMapping("/signup")
    public String getSignUp(UserEntityDto userEntityDto) {
        return "userCreateForm";
    }

    @PostMapping("/signup")
    public String postSignUp(@Valid UserEntityDto userEntityDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "userCreateForm";
        }
        return "redirect:/";
    }
}
