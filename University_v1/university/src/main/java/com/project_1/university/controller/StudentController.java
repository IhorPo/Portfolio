package com.project_1.university.controller;

import com.project_1.university.models.StudentPojo;
import com.project_1.university.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("university/students")
public class StudentController {
    private final StudentService service;
    @Autowired
    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping
    public String getAll(Model model){
        model.addAttribute("students",service.getAll());
        return "students";
    }

    @GetMapping("/{id}")
    public String studentById(@PathVariable("id") Integer id, Model model){
        model.addAttribute("student",service.findById(id));
        return "student";
    }

    @GetMapping("/new")
    public String form(Model model){
        model.addAttribute("student",new StudentPojo());
        return "studentForm";
    }

    @PostMapping
    public String save( StudentPojo student){
        try {
            service.add(student);
        } catch (Exception e){
            e.getMessage();
        }
        return "redirect:/university/students";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id")int id, Model model){
        StudentPojo student = service.findById(id);
        model.addAttribute("student",student);
        return "editStudent";
    }

    @PostMapping("/editSave")
    public String editSave(@ModelAttribute("student") StudentPojo student){
        service.update(student);
        return "redirect:/university/students";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id){
        service.delete(id);
        return "redirect:/university/students";
    }
}
