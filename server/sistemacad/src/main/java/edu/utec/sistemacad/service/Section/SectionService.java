package edu.utec.sistemacad.service.Section;

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
import edu.utec.sistemacad.repository.StudentRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SectionService {
    @Autowired
    private SectionRepository sectionRepository;

    @Autowired
    private StudentRepository studentRepository;

    public ResponseEntity<List<Section>> getAllSections(){
        List<Section> sections = sectionRepository.findAll();
        return new ResponseEntity<>(sections, HttpStatus.OK);
    }

    public ResponseEntity<Section> getSectionById(@PathVariable Long id){
        Optional<Section> section = sectionRepository.findById(id);
        if(section.isPresent()){
            return new ResponseEntity<>(section.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<List<Student>> getStudentsBySection(@PathVariable Long id){
        Optional<Section> section = sectionRepository.findById(id);
        if(section.isPresent()){
            List<Student> sectionsList = new ArrayList<>(section.get().getStudents());
            return new ResponseEntity<>(sectionsList, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<String> postSection(@RequestBody Section request) {
        Section newSection = request;

        // Obtener estudiantes existentes por sus IDs
        List<Student> students = new ArrayList<>();
        for (Student student : request.getStudents()) {
            Long studentId = student.getId();
            Student studentExists = studentRepository.findById(studentId).orElse(null);
            if (studentExists == null) {
                return ResponseEntity.badRequest().body("El estudiante con ID " + studentId + " no existe.");
            }
            students.add(studentExists);
        }
        newSection.setStudents(students);
        sectionRepository.save(newSection);

        return ResponseEntity.ok("Sección creada con éxito y se le asignaron los estudiantes existentes.");
    }

    public ResponseEntity<List<Session>> getSessionsBySection(@PathVariable Long id){
        Optional<Section> section = sectionRepository.findById(id);
        if(section.isPresent()){
            List<Session> sessions = new ArrayList<>(section.get().getSessions());
            return new ResponseEntity<>(sessions, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<String> deleteSection(@PathVariable Long id) {
        Optional<Section> OptionalSection = sectionRepository.findById(id);
        if (OptionalSection.isPresent()) {
            sectionRepository.deleteById(id);
            return ResponseEntity.status(200).body("Section deleted");
        }else {
            return ResponseEntity.status(404).body("Not Found");
        }
    }
}
