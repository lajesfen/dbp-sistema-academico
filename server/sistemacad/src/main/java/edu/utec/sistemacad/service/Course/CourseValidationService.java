package edu.utec.sistemacad.service.Course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.utec.sistemacad.repository.CourseRepository;

@Service
public class CourseValidationService {
    @Autowired
    private CourseRepository courseRepository;

    public boolean isCourseNameUnique(String name) {
        return courseRepository.countByName(name) == 0;
    }

    public boolean isCourseNameValid(String name) {
        // Verifica si el nombre del curso es único
        long count = courseRepository.countByName(name);

        if (count > 0) {
            return false; // El nombre no cumple con la validación
        }
        return true;
    }

}
