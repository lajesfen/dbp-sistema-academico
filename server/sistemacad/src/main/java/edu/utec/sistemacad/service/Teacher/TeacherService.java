package edu.utec.sistemacad.service.Teacher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import edu.utec.sistemacad.model.Section;
import edu.utec.sistemacad.model.Session;
import edu.utec.sistemacad.model.Teacher;
import edu.utec.sistemacad.repository.TeacherRepository;

import java.util.Optional;
import java.util.ArrayList;
import java.util.List;

@Service
public class TeacherService {
    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private TeacherValidationService teacherValidationService;

    public ResponseEntity<List<Teacher>> getAllTeachers() {
        List<Teacher> teachers = teacherRepository.findAll();
        return new ResponseEntity<>(teachers, HttpStatus.OK);
    }

    public ResponseEntity<Teacher> getTeacherById(@PathVariable Long id) {
        if (!teacherRepository.existsById(id)) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        Teacher existingTeacher = teacherRepository.findById(id).get();
        return new ResponseEntity<>(existingTeacher, HttpStatus.OK);
    }

    public ResponseEntity<Teacher> getTeachersByEmail(@PathVariable String email){
        Optional<Teacher> teacher = teacherRepository.findByEmail(email);
        if(teacher.isPresent()){
            return new ResponseEntity<>(teacher.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<List<Session>> getSessionsByTeacher(@PathVariable Long id){
        if(!teacherRepository.existsById(id)){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        Optional<Teacher> teacher =  teacherRepository.findById(id);
        List<Session> sessions = new ArrayList<>();

        for (Section section : teacher.get().getSections()) {
            sessions.addAll(section.getSessions());
        }

        return new ResponseEntity<>(sessions, HttpStatus.OK);
    }

    public ResponseEntity<String> newTeacher(@RequestBody Teacher teacher){
        if (!teacherValidationService.isTeacherEmailValid(teacher.getEmail())) {
            return ResponseEntity.badRequest().body("Email no válido.");
        }
        if (!teacherValidationService.isTeacherDNIValid(teacher.getDni())) {
            return ResponseEntity.badRequest().body("DNI no válido.");
        }
        if (!teacherValidationService.isTeacherNameValid(teacher.getName())) {
            return ResponseEntity.badRequest().body("Nombre no válido.");
        }
        teacherRepository.save(teacher);
        return ResponseEntity.status(201).body("Created");
    }

    public ResponseEntity<String> deleteTeacher(@PathVariable Long id) {
        if (!teacherRepository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Teacher with code " + id + " not found");
        }
        teacherRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Deleted");
    }
}
