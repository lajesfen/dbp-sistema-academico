package edu.utec.sistemacad.service.Student;


import edu.utec.sistemacad.model.Grade;
import edu.utec.sistemacad.model.Section;
import edu.utec.sistemacad.model.Session;
import edu.utec.sistemacad.model.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import edu.utec.sistemacad.repository.SectionRepository;
import edu.utec.sistemacad.repository.SessionRepository;
import edu.utec.sistemacad.repository.StudentRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private StudentValidationService studentValidationService;
    @Autowired
    private SectionRepository sectionRepository;
    @Autowired
    private SessionRepository sessionRepository;

    public ResponseEntity<List<Student>> getAllStudents(){
        List<Student> students = studentRepository.findAll();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }
    public ResponseEntity<List<Section>> getAllSections(){
        List<Section> sections = sectionRepository.findAll();
        return new ResponseEntity<>(sections, HttpStatus.OK);
    }
    public ResponseEntity<List<Session>> getAllSessions(){
        List<Session> sessions = sessionRepository.findAll();
        return new ResponseEntity<>(sessions, HttpStatus.OK);
    }

    public ResponseEntity<Student> getStudentsById(Long id){
        Optional<Student> student = studentRepository.findById(id);
        if(student.isPresent()){
            Student foundStudent = student.get();
            return ResponseEntity.ok(foundStudent);
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<Student> getStudentsByEmail(@PathVariable String email){
        Optional<Student> student = studentRepository.findByEmail(email);
        if(student.isPresent()){
            return new ResponseEntity<>(student.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<List<Section>> getSectionsByStudents(@PathVariable Long id){
        Optional<Student> student = studentRepository.findById(id);
        if(student.isPresent()){
            List<Section> sectionsList = new ArrayList<>(student.get().getSections());
            return new ResponseEntity<>(sectionsList, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<List<Session>> getSessionsByStudents(@PathVariable Long id){
        Optional<Student> student = studentRepository.findById(id);
        if(student.isPresent()){
            List<Session> sessions = new ArrayList<>();

            for (Section section : student.get().getSections()) {
                sessions.addAll(section.getSessions());
            }

            return new ResponseEntity<>(sessions, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<List<Grade>> getGradesByStudents(@PathVariable Long id){
        Optional<Student> student = studentRepository.findById(id);
        if(student.isPresent()){
            List<Grade> finalGradeList = new ArrayList<>(student.get().getGrades());
            return new ResponseEntity<>(finalGradeList, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<String> postStudent(@RequestBody Student student) {
        if (!studentValidationService.isStudentEmailValid(student.getEmail())) {
            return ResponseEntity.badRequest().body("Email no válido.");
        }
        if (!studentValidationService.isStudentDNIValid(student.getDni())) {
            return ResponseEntity.badRequest().body("DNI no válido.");
        }
        if (!studentValidationService.isStudentPhoneValid(student.getPhone())) {
            return ResponseEntity.badRequest().body("Número telefónico no válido.");
        }
        if (!studentValidationService.isStudentNameValid(student.getName())) {
            return ResponseEntity.badRequest().body("Nombre no válido.");
        }

        List<Section> sections = student.getSections();
        if (sections != null && !sections.isEmpty()) {
            for (Section section : sections) {
                section.getStudents().add(student);
            }
        }

        studentRepository.save(student);
        return ResponseEntity.status(201).body("Created");
    }

    public ResponseEntity<String> deleteStudent(@PathVariable Long id) {
        Optional<Student> OptionalCourse = studentRepository.findById(id);
        if (OptionalCourse.isPresent()) {
            studentRepository.deleteById(id);
            return ResponseEntity.status(200).body("Student deleted");
        }else {
            return ResponseEntity.status(404).body("Not Found");
        }
    }
}