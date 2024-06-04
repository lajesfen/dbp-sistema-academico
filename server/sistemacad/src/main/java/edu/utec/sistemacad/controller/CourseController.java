package edu.utec.sistemacad.controller;

import edu.utec.sistemacad.model.Grade;
import edu.utec.sistemacad.service.Course.CourseService;
import edu.utec.sistemacad.model.Course;
import edu.utec.sistemacad.model.Section;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping
    public ResponseEntity<List<Course>> courses(){
        return courseService.getAllCourses();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Course> course_id(@PathVariable Long id){
        return courseService.getCourseById(id);
    }

    @GetMapping("/section/{id}")
    public ResponseEntity<List<Section>> sections(@PathVariable Long id){
        return courseService.getSectionsByCourse(id);
    }

    @GetMapping("/grades/{id}")
    public ResponseEntity<List<Grade>> grades(@PathVariable Long id){
        return courseService.getGradesByCourse(id);
    }

    @PostMapping
    public ResponseEntity<String> postCourses(@RequestBody Course course) {
        return courseService.postCourse(course);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCourse_id(@PathVariable Long id) {
        return courseService.deleteCourse(id);
    }
}
