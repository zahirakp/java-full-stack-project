package com.example.backend.controller;

import com.example.backend.entity.Student;
import com.example.backend.dto.ProfileResponse;
import com.example.backend.repository.StudentRepository;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

// This class handles student profile.
@RestController
@RequestMapping("/api/profile")
public class ProfileController {

    private final StudentRepository studentRepository;

    // Connects to the database.
    public ProfileController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // Shows the student profile.
    @GetMapping
    public ProfileResponse getProfile(Authentication auth) {

        Student student = studentRepository.findByEmail(auth.getName())
                .orElseThrow();

        return convertToResponse(student);
    }

    // Updates the student profile.
    @PutMapping
    public ProfileResponse updateProfile(
            Authentication auth,
            @RequestBody Student request) {

        Student student = studentRepository.findByEmail(auth.getName())
                .orElseThrow();

        student.setName(request.getName());  //update the name
        student.setEmail(request.getEmail());  //update the email

        studentRepository.save(student);  //save to db

        return convertToResponse(student);
    }

    // Sends only safe details.
    private ProfileResponse convertToResponse(Student student) {

        ProfileResponse response = new ProfileResponse();

        response.setId(student.getId());
        response.setName(student.getName());
        response.setEmail(student.getEmail());

        return response;
    }

    // Deletes the student account.
    @DeleteMapping
    public String deleteProfile(Authentication auth) {

        // Finds the logged-in student.
        Student student = studentRepository.findByEmail(auth.getName())
                .orElseThrow();

        // Deletes the student.
        studentRepository.delete(student);

        return "Account deleted successfully";
    }
}

// Register
// Zahira enters her name, email, and password.
// POST /api/auth/register
// The backend hashes the password and saves it in MySQL.

// Login
// Zahira enters her email and password.
// POST /api/auth/login
// The backend checks the password and returns a JWT token.

// View Profile
// The frontend sends the JWT token.
// GET /api/profile
// The filter checks the token.
// ProfileController returns the profile details.

// Update Profile
// Zahira changes her name.
// PUT /api/profile
// The backend updates the database.

// Delete Profile
// Zahira deletes her account.
// DELETE /api/profile
// The student is deleted from the database.