
package com.example.backend.controller;

import com.example.backend.dto.RegisterRequest;
import com.example.backend.dto.LoginRequest;
import com.example.backend.dto.LoginResponse;
import com.example.backend.service.AuthService;

import org.springframework.web.bind.annotation.*;

// This class handles register and login requests.
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    // Connects AuthService.
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    // Registers student and returns token.
    @PostMapping("/register")
    public LoginResponse register(@RequestBody RegisterRequest request) {
        return authService.register(request);
    }

    // Logs in student and returns token.
    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request) {
        return authService.login(request);
    }
}
