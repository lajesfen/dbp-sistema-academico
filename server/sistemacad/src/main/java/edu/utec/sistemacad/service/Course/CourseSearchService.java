package edu.utec.sistemacad.service.Course;

import edu.utec.sistemacad.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.utec.sistemacad.repository.CourseRepository;

import java.util.List;

@Service
public class CourseSearchService {
    @Autowired
    private CourseRepository courseRepository;

    public List<Course> searchCoursesByName(String name) {
        return courseRepository.findByName(name);
    }
    public List<Course> searchCoursesByArea(String area) {
        return courseRepository.findByArea(area);
    }
    public List<Course> searchCoursesByProgram(String program) {
        return courseRepository.findByProgram(program);
    }
}
