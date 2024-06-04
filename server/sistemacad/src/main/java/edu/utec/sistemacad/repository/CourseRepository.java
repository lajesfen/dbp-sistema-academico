package edu.utec.sistemacad.repository;

import edu.utec.sistemacad.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long>{
    public List<Course> findByArea(String area);

    public List<Course> findByProgram(String program);

    public List<Course> findByName(String name);

    public int countByName(String name);
}
