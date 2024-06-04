package edu.utec.sistemacad.service.Grade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import edu.utec.sistemacad.model.Grade;
import edu.utec.sistemacad.repository.GradeRepository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class GradeService {
    @Autowired
    private GradeRepository finalGradeRepository;

    public ResponseEntity<List<Grade>> getAllFinalGrades(){
        List<Grade> finalGrades  = finalGradeRepository.findAll();
        return new ResponseEntity<>(finalGrades, HttpStatus.OK);
    }

    public ResponseEntity<Grade> getGradeById(@PathVariable Long id){
        Optional<Grade> finalGrade = finalGradeRepository.findById(id);
        if(finalGrade.isPresent()){
            return new ResponseEntity<>(finalGrade.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<String> newFinalGrade(@RequestBody Grade finalGrade) {
        finalGradeRepository.save(finalGrade);
        return ResponseEntity.status(201).body("Created");
    }

    public ResponseEntity<String> deleteFinalGradeByID(@PathVariable Long id) {
        if (!finalGradeRepository.existsById(id)) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        finalGradeRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Deleted");
    }

    public List<Grade> getPagosByStudentId(Long studentId) {
        return finalGradeRepository.findByStudentId(studentId);
    }

    public List<Grade> getGradesByCourseId(String courseId) {
        return finalGradeRepository.findByCourseId(courseId);
    }
}
