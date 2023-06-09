package com.project_1.university.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("university")
public class UniversityController {
    @GetMapping
    public String university(){
        return "universityMain";
    }

    @GetMapping("/studentLife")
    public String studentLife(){
        return "studentLife";
    }

    @GetMapping("/about")
    public String about(){
        return "about";
    }
}
