package com.example.lab6.lab6.restcontrollers;

import com.example.lab6.lab6.Service.CoursesService;
import com.example.lab6.lab6.model.Courses;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CoursesRestController {

    private final CoursesService coursesService;

    public CoursesRestController(CoursesService coursesService) {
        this.coursesService = coursesService;
    }

    @GetMapping
    public List<Courses> getAllCourses() {
        return coursesService.getAllCourses();
    }

    @GetMapping("/{id}")
    public Courses getCourseById(@PathVariable Long id) {
        return coursesService.getCourseById(id);
    }

    @PostMapping
    public Courses addCourse(@RequestBody Courses course) {
        return coursesService.saveCourse(course);
    }

    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable Long id) {
        coursesService.deleteCourse(id);
    }
}
