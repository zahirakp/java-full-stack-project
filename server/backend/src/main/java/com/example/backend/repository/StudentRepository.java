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
// Checks whether this email already exists in the database.

//studentRepository.findByEmail("zay@gmail.com");
// Finds the student with this email.

//Important:
// existsByEmail() and findByEmail() are custom methods created by us.
// Spring Data JPA automatically generates the database query by reading the method name.