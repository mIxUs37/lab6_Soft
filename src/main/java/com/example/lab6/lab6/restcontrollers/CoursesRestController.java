package com.example.lab6.lab6.restcontrollers;

import com.example.lab6.lab6.Service.CoursesService;
import com.example.lab6.lab6.dto.CoursesDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/courses")
public class CoursesRestController {

    private final CoursesService coursesService;

    @GetMapping
    public ResponseEntity<?> getAllCourses() {
        List<CoursesDto> list = coursesService.getAllCoursesDto();
        if (list.isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCourseById(@PathVariable Long id) {
        CoursesDto dto = coursesService.getCourseDtoById(id);
        if (Objects.isNull(dto)) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<?> addCourse(@RequestBody CoursesDto dto) {
        CoursesDto created = coursesService.addCourseDto(dto);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCourse(@PathVariable Long id, @RequestBody CoursesDto dto) {
        CoursesDto updated = coursesService.updateCourseDto(id, dto);
        if (Objects.isNull(updated)) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCourse(@PathVariable Long id) {
        boolean deleted = coursesService.deleteCourseDto(id);
        if (!deleted) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
