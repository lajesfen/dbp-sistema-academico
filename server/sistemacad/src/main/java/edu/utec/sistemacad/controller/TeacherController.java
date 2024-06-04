package edu.utec.sistemacad.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import edu.utec.sistemacad.model.Session;
import edu.utec.sistemacad.model.Teacher;
import edu.utec.sistemacad.service.Teacher.TeacherService;

@RestController
@RequestMapping("/teachers")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @GetMapping
    public ResponseEntity<List<Teacher>> teachers() {
        return teacherService.getAllTeachers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Teacher> teacher(@PathVariable Long id){
        return teacherService.getTeacherById(id);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<Teacher> teacherEmail(@PathVariable String email){
        return teacherService.getTeachersByEmail(email);
    }

    @GetMapping("/session/{id}")
    public ResponseEntity<List<Session>> sessionsOfTeacher(@PathVariable Long id){
        return teacherService.getSessionsByTeacher(id);
    }

    @PostMapping
    public ResponseEntity<String> newTeacher(@RequestBody Teacher teacher){
        return teacherService.newTeacher(teacher);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTeacher(@PathVariable Long id){
        return teacherService.deleteTeacher(id);
    }
}
