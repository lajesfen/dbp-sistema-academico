package edu.utec.sistemacad.controller;

import edu.utec.sistemacad.model.Grade;
import edu.utec.sistemacad.service.Student.StudentService;
import edu.utec.sistemacad.model.Section;
import edu.utec.sistemacad.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping
    public ResponseEntity<List<Student>> students(){
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> student(@PathVariable Long id){
        return studentService.getStudentsById(id);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<Student> studentEmail(@PathVariable String email){
        return studentService.getStudentsByEmail(email);
    }

    @GetMapping("/section/{id}")
    public ResponseEntity<List<Section>> section(@PathVariable Long id){
        return studentService.getSectionsByStudents(id);
    }

    @GetMapping("/grades/{id}")
    public ResponseEntity<List<Grade>> grades(@PathVariable Long id){
        return studentService.getGradesByStudents(id);
    }

    @PostMapping()
    public ResponseEntity<String> Student(@RequestBody Student student) {
        return studentService.postStudent(student);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent_id(@PathVariable Long id){
        return studentService.deleteStudent(id);
    }
}
