package edu.utec.sistemacad.repository;

import edu.utec.sistemacad.model.Grade;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GradeRepository extends JpaRepository<Grade, Long> {
    public List<Grade> findByStudentId(Long student_id);

    public List<Grade> findByCourseId(String course_id);
}
