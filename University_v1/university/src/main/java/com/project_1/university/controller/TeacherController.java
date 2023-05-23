package com.project_1.university.controller;

import com.project_1.university.models.StudentPojo;
import com.project_1.university.models.TeacherPojo;
import com.project_1.university.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("university/teachers")
public class TeacherController {
    private final TeacherService service;
    @Autowired
    public TeacherController(TeacherService service) {
        this.service = service;
    }
    @GetMapping
    public String getAll(Model model){
        model.addAttribute("teachers",service.getAll());
        return "teachers";
    }

    @GetMapping("/{id}")
    public String getById(@PathVariable("id") Integer id,
                               Model model){
        model.addAttribute("teacher",service.getById(id));
        return "teacher";
    }

    @GetMapping("/new")
    public String form(Model model){
        model.addAttribute("teacher",new TeacherPojo());
        return "teacherForm";
    }

    @PostMapping
    public String save(TeacherPojo teacher){
        try {
            service.add(teacher);
        } catch (Exception e){
            e.getMessage();
        }
        return "redirect:/university/teachers";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") int id,
                       Model model){
        model.addAttribute("teacher",service.update(service.getById(id)));
        return "editTeacher";
    }

    @PostMapping("/editSave")
    public String editSave(@ModelAttribute("student") TeacherPojo teacher){
        service.update(teacher);
        return "redirect:/university/teachers";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id){
        service.delete(id);
        return "redirect:/university/teachers";
    }
}
