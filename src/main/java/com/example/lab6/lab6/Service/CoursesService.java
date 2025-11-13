package com.example.lab6.lab6.Service;

import com.example.lab6.lab6.Repository.CoursesRepository;
import com.example.lab6.lab6.dto.CoursesDto;
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

    // ======== CRUD для DTO ========

    public List<CoursesDto> getAllCoursesDto() {
        List<Courses> courses = coursesRepository.findAll();
        List<CoursesDto> dtos = new ArrayList<>();
        for (Courses c : courses) {
            dtos.add(toDto(c));
        }
        return dtos;
    }

    public CoursesDto getCourseDtoById(Long id) {
        Courses course = coursesRepository.findById(id).orElse(null);
        if (Objects.isNull(course)) return null;
        return toDto(course);
    }

    public CoursesDto addCourseDto(CoursesDto dto) {
        Courses entity = toEntity(dto);
        Courses saved = coursesRepository.save(entity);
        return toDto(saved);
    }

    public CoursesDto updateCourseDto(Long id, CoursesDto dto) {
        Courses existing = coursesRepository.findById(id).orElse(null);
        if (existing == null) return null;
        existing.setName(dto.getName());
        existing.setDescription(dto.getDescription());
        Courses updated = coursesRepository.save(existing);
        return toDto(updated);
    }

    public boolean deleteCourseDto(Long id) {
        Courses existing = coursesRepository.findById(id).orElse(null);
        if (existing == null) return false;
        coursesRepository.delete(existing);
        return true;
    }

    public CoursesDto toDto(Courses course) {
        return CoursesDto.builder()
                .id(course.getId())
                .name(course.getName())
                .description(course.getDescription())
                .build();
    }

    public Courses toEntity(CoursesDto dto) {
        Courses course = new Courses();
        course.setId(dto.getId());
        course.setName(dto.getName());
        course.setDescription(dto.getDescription());
        return course;
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
