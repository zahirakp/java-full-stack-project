
package com.example.backend.service;

import com.example.backend.dto.RegisterRequest;
import com.example.backend.dto.LoginRequest;
import com.example.backend.dto.LoginResponse;
import com.example.backend.entity.Student;
import com.example.backend.repository.StudentRepository;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

// This class handles register and login.
@Service
public class AuthService {

    private final StudentRepository studentRepository;
    private final JwtService jwtService;

    // This protects passwords.
    private final BCryptPasswordEncoder passwordEncoder =
            new BCryptPasswordEncoder();

    // Connects required services.
    public AuthService(StudentRepository studentRepository,
                       JwtService jwtService) {
        this.studentRepository = studentRepository;
        this.jwtService = jwtService;
    }

    // Registers a new student.
    public LoginResponse register(RegisterRequest request) {

        // Checks if email already exists.
        if (studentRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already registered");
        }

        // Creates a new student.
        Student student = new Student();

        student.setName(request.getName());
        student.setEmail(request.getEmail());

        // Protects the password.
        student.setPassword(passwordEncoder.encode(request.getPassword()));

        // Saves student details.
        studentRepository.save(student);

        // Creates a login token.
        String token = jwtService.generateToken(student.getEmail());

        // Sends the token to frontend.
        LoginResponse response = new LoginResponse();
        response.setToken(token);

        return response;
    }

    // Checks login details.
    public LoginResponse login(LoginRequest request) {

        // Finds student using email.
        Optional<Student> student =
                studentRepository.findByEmail(request.getEmail());

        // Checks email.
        if (student.isEmpty()) {
            throw new RuntimeException("Invalid email or password");
        }

        // Checks password.
        boolean passwordCorrect = passwordEncoder.matches(
                request.getPassword(),
                student.get().getPassword()
        );

        // Stops if password is wrong.
        if (!passwordCorrect) {
            throw new RuntimeException("Invalid email or password");
        }

        // Creates a login token.
        String token = jwtService.generateToken(student.get().getEmail());

        // Sends the token.
        LoginResponse response = new LoginResponse();
        response.setToken(token);

        return response;
    }
}
