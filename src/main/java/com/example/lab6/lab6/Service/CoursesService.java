package com.example.lab6.lab6.Service;

import com.example.lab6.lab6.model.Courses;
import com.example.lab6.lab6.Repository.CoursesRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CoursesService {

    private final CoursesRepository coursesRepository;

    public CoursesService(CoursesRepository coursesRepository) {
        this.coursesRepository = coursesRepository;
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