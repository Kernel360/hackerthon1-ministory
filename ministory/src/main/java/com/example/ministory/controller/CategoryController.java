package com.example.ministory.controller;

import com.example.ministory.dto.UserDto;
import com.example.ministory.entity.User;
import com.example.ministory.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.ministory.dto.CategoryDto;
import com.example.ministory.entity.Category;
import com.example.ministory.service.CategoryService;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/api/category")
public class CategoryController {
    private CategoryService categoryService;

    @GetMapping("/")
    public String getCategoryList(Model model, @RequestParam Long userId) {
        // User user = /* Use userId to retrieve the user */;
        return "categoryList";
    }


    //@GetMapping("/")
    // public String getSignUp(UserDto userDto) {
        //return "userCreateForm";
    //}

}
