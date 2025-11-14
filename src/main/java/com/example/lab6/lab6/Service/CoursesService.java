package com.example.lab6.lab6.Service;

import com.example.lab6.lab6.Repository.CoursesRepository;
import com.example.lab6.lab6.model.Courses;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class CoursesService {

    private final CoursesRepository coursesRepository;

    public CoursesService(CoursesRepository coursesRepository) {
        this.coursesRepository = coursesRepository;
    }


    public boolean deleteCourseDto(Long id) {
        Courses existing = coursesRepository.findById(id).orElse(null);
        if (existing == null) return false;
        coursesRepository.delete(existing);
        return true;
    }


    public List<Courses> getAllCourses() {
        return coursesRepository.findAll();
    }

    public Courses getCourseById(Long id) {
        return coursesRepository.findById(id).orElse(null);
    }

    public void addCourse(Courses course) {
        coursesRepository.save(course);
    }

    public void updateCourse(Courses course) {
        coursesRepository.save(course);
    }

    public Courses saveCourse(Courses course) {
        return coursesRepository.save(course);
    }

    public void deleteCourse(Long id) {
        coursesRepository.deleteById(id);
    }
}
