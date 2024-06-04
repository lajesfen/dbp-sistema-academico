package edu.utec.sistemacad.controller;

import java.util.List;

import edu.utec.sistemacad.service.Grade.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import edu.utec.sistemacad.model.Grade;

@RestController
@RequestMapping("/grades")
public class GradeController {
    @Autowired
    private GradeService finalGradeService;

    @GetMapping
    public ResponseEntity<List<Grade>> finalGrades() {
        return finalGradeService.getAllFinalGrades();
    }

    @GetMapping("/{finalGradeId}")
    public ResponseEntity<Grade> getPagoById(@PathVariable Long finalGradeId) {
        return finalGradeService.getGradeById(finalGradeId);
    }

    @PostMapping
    public ResponseEntity<String> newFinalGrade(@RequestBody Grade finalGrade){
        return finalGradeService.newFinalGrade(finalGrade);
    }

    @DeleteMapping("/{finalGradeId}")
    public ResponseEntity<String> deletePago(@PathVariable Long finalGradeId) {
        return finalGradeService.deleteFinalGradeByID(finalGradeId);
    }
}
