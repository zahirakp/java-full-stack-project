package com.example.backend.repository;

import com.example.backend.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// This interface works with the student table.
public interface StudentRepository extends JpaRepository<Student, Long> {

    // Checks if this email is already used.
    boolean existsByEmail(String email);

    // Finds a student using their email.
    Optional<Student> findByEmail(String email);
}
//studentRepository.existsByEmail("zay@gmail.com");
//Database-il ee email already undo ennu check cheyyum.
//studentRepository.findByEmail("zay@gmail.com");
//Ee email ulla student-ne find cheyyum.
//Important: existsByEmail() and findByEmail() nammal create cheytha methods aanu.
// Spring Data JPA method name nokki query generate cheyyum.