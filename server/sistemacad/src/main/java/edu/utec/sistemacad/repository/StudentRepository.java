package edu.utec.sistemacad.repository;

import edu.utec.sistemacad.model.Student;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{
    public Optional<Student> findByEmail(String email);
}

