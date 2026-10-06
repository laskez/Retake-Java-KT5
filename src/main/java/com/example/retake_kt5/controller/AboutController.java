package com.example.retake_kt5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AboutController {

    @GetMapping("/about")
    public String about(Model model) {
        model.addAttribute("title", "О приложении");
        model.addAttribute("description", "Учебное приложение для КТ-2 по Spring MVC");
        return "about";
    }
}
