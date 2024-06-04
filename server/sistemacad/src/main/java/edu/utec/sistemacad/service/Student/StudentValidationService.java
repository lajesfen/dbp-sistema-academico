package edu.utec.sistemacad.service.Student;

import org.springframework.stereotype.Service;


@Service
public class StudentValidationService {
        public boolean isStudentEmailValid(String email) {
            // Validar el formato del correo electrónico
            return email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}$");
        }

        public boolean isStudentDNIValid(String dni) {
            // Validar el formato del DNI (8 dígitos)
            return dni.matches("^\\d{8}$");
        }

        public boolean isStudentPhoneValid(String phone) {
            // Validar el formato del número de teléfono (9 dígitos)
            return phone.matches("^\\d{9}$");
        }

        public boolean isStudentNameValid(String name) {
            // Validar el formato del nombre (solo letras y espacios)
            return name.matches("^[A-Za-z\\s]+$");
        }
}
