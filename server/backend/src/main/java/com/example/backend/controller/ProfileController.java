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

//Register
//Zahira name, email, password enter cheyyunnu.
//POST /api/auth/register
//Backend password hash cheythu MySQL-il save cheyyunnu.
//
//Login
//Zahira email and password enter cheyyunnu.
//POST /api/auth/login
//Backend password match cheythu JWT token return cheyyunnu.
//
//View Profile
//Frontend JWT token send cheyyunnu.
//GET /api/profile
//Filter token check cheyyunnu. ProfileController details return cheyyunnu.
//
//Update Profile
//Zahira name change cheyyunnu.
// PUT /api/profile
//Backend database update cheyyunnu.
//
//Delete Profile
//Zahira account delete cheyyunnu.
//DELETE /api/profile
//Database-il ninn student delete cheyyunnu.