package edu.utec.sistemacad.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.utec.sistemacad.model.Session;
import java.util.List;

@Repository
public interface SessionRepository extends JpaRepository<Session, Long>{
    public List<Session> findBySectionId(Long id);
}