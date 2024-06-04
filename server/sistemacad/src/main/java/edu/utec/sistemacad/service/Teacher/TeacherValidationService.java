package edu.utec.sistemacad.service.Teacher;

import org.springframework.stereotype.Service;

@Service
public class TeacherValidationService {
    
    public boolean isTeacherEmailValid(String email){
        return email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}$");
    }

    public boolean isTeacherDNIValid(String dni){
        return dni.matches("^\\d{8}$");
    }

    public boolean isTeacherNameValid(String name){
        return name.matches("^[A-Za-z\\s]+$");
    }
}
