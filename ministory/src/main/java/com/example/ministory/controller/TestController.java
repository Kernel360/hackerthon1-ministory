package com.example.ministory.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class TestController {

    @GetMapping("/test")
    public String responseTest(Model model) {
        model.addAttribute("testMessage", "hello");
        return "hello";
    }
}
