package edu.utec.sistemacad.controller;

import edu.utec.sistemacad.model.Session;
import edu.utec.sistemacad.service.Section.SectionService;
import edu.utec.sistemacad.model.Section;
import edu.utec.sistemacad.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sections")
public class SectionController {
    @Autowired
    private SectionService sectionService;

    @GetMapping
    public ResponseEntity<List<Section>> sections(){
        return sectionService.getAllSections();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Section> section(@PathVariable Long id){
        return sectionService.getSectionById(id);
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<List<Student>> groups(@PathVariable Long id){
        return sectionService.getStudentsBySection(id);
    }

    @GetMapping("/session/{id}")
    public ResponseEntity<List<Session>> grades(@PathVariable Long id){
        return sectionService.getSessionsBySection(id);
    }

    @PostMapping()
    public ResponseEntity<String> Section(@RequestBody Section section) {
        return sectionService.postSection(section);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSection_id(@PathVariable Long id){
        return sectionService.deleteSection(id);
    }
}
