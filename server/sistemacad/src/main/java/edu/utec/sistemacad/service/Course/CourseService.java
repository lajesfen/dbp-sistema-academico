package edu.utec.sistemacad.service.Course;

import edu.utec.sistemacad.model.Course;
import edu.utec.sistemacad.model.Grade;
import edu.utec.sistemacad.model.Section;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import edu.utec.sistemacad.repository.CourseRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private CourseValidationService courseValidationService;
    public ResponseEntity<List<Course>> getAllCourses(){
        List<Course> courses = courseRepository.findAll();
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }

    public ResponseEntity<Course> getCourseById(@PathVariable Long id){
        Optional<Course> course = courseRepository.findById(id);
        if(course.isPresent()){
            return new ResponseEntity<>(course.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<List<Section>> getSectionsByCourse(@PathVariable Long id){
        Optional<Course> course = courseRepository.findById(id);
        if(course.isPresent()){
            List<Section> sectionsList = new ArrayList<>(course.get().getSections());
            return new ResponseEntity<>(sectionsList, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<List<Grade>> getGradesByCourse(@PathVariable Long id){
        Optional<Course> course = courseRepository.findById(id);
        if(course.isPresent()){
            List<Grade> finalGrades = new ArrayList<>(course.get().getGrades());
            return new ResponseEntity<>(finalGrades, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<String> postCourse(@RequestBody Course course) {
        if (!courseValidationService.isCourseNameValid(course.getName())) {
            return ResponseEntity.badRequest().body("Nombre de curso no válido.");
        }
        // Validar si el nombre del curso es único
        if (!courseValidationService.isCourseNameUnique(course.getName())) {
            return ResponseEntity.badRequest().body("El nombre del curso ya existe.");
        }

        courseRepository.save(course);
        return ResponseEntity.status(201).body("Created");
    }

    public ResponseEntity<String> deleteCourse(@PathVariable Long id) {
        Optional<Course> OptionalCourse = courseRepository.findById(id);
        if (OptionalCourse.isPresent()) {
            courseRepository.deleteById(id);
            return ResponseEntity.status(200).body("Course Deleted");
        }else {
            return ResponseEntity.status(404).body("Not Found");
        }
    }
}
