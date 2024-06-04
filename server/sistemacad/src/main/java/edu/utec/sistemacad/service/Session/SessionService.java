package edu.utec.sistemacad.service.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import edu.utec.sistemacad.model.Section;
import edu.utec.sistemacad.model.Session;
import edu.utec.sistemacad.model.Teacher;
import edu.utec.sistemacad.repository.SessionRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SessionService {
    @Autowired
    private SessionRepository sessionRepository;    

    public ResponseEntity<List<Session>> getAllSessions(){
        List<Session> sessions = sessionRepository.findAll();
        return new ResponseEntity<>(sessions, HttpStatus.OK); 
    }

    public ResponseEntity<Session> getSessionById(@PathVariable Long id){
        Optional<Session> session = sessionRepository.findById(id);
        if(session.isPresent()){
            return new ResponseEntity<>(session.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<Section> getSectionById(@PathVariable Long id){
        if(!sessionRepository.existsById(id)){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        Section section =  sessionRepository.findById(id).get().getSection();
        return new ResponseEntity<>(section, HttpStatus.OK);
    }

    public ResponseEntity<Teacher> getTeacherById(@PathVariable Long id){
        if(!sessionRepository.existsById(id)){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        Teacher teacher =  sessionRepository.findById(id).get().getSection().getTeacher();
        return new ResponseEntity<>(teacher, HttpStatus.OK);
    }

    public ResponseEntity<String> newSession(@RequestBody Session session) {
        sessionRepository.save(session);
        return ResponseEntity.status(201).body("Created");
    }

    public ResponseEntity<String> deleteSessionByID(@PathVariable Long id) {
        if (!sessionRepository.existsById(id)) {
             return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        sessionRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Deleted");
    }
}
