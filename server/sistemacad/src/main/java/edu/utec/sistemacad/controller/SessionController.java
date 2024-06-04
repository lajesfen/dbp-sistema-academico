package edu.utec.sistemacad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import edu.utec.sistemacad.model.Section;
import edu.utec.sistemacad.model.Session;
import edu.utec.sistemacad.model.Teacher;
import edu.utec.sistemacad.service.Session.SessionService;

import java.util.List;


@RestController
@RequestMapping("/sessions")
public class SessionController {
    @Autowired
    private SessionService sessionService;

    @GetMapping
    public ResponseEntity<List<Session>> sessions(){
        return sessionService.getAllSessions();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Session> session(@PathVariable Long id){
        return sessionService.getSessionById(id);
    }

    @GetMapping("/{id}/section/")
    public ResponseEntity<Section> section(@PathVariable Long id){
        return sessionService.getSectionById(id);
    }

    @GetMapping("/{id}/teacher/")
    public ResponseEntity<Teacher> teacher(@PathVariable Long id){
        return sessionService.getTeacherById(id);
    }

    @PostMapping
    public ResponseEntity<String> Session(@RequestBody Session session) {
        return sessionService.newSession(session);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> DeleteSession(@PathVariable Long id){
        return sessionService.deleteSessionByID(id);
    }
}