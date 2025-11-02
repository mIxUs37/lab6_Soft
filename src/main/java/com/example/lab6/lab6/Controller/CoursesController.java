package com.example.lab6.lab6.Controller;

import com.example.lab6.lab6.Service.CoursesService;
import com.example.lab6.lab6.model.Courses;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/courses")
public class CoursesController {

    private final CoursesService service;

    public CoursesController(CoursesService service) {
        this.service = service;
    }

    @GetMapping
    public String listCourses(Model model) {
        model.addAttribute("courses", service.getAllCourses());
        return "courses";
    }

    @GetMapping("/add")
    public String addCourseForm(Model model) {
        model.addAttribute("course", new Courses());
        return "add-course";
    }

    @PostMapping("/add")
    public String addCourse(@ModelAttribute Courses course) {
        service.addCourse(course);
        return "redirect:/courses";
    }

    @PostMapping("/delete/{id}")
    public String deleteCourse(@PathVariable Long id) {
        service.deleteCourse(id);
        return "redirect:/courses";
    }
}
