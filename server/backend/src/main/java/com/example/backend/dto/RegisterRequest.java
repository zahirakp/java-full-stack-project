
package com.example.backend.dto;

// This class receives registration details.
public class RegisterRequest {

    private String name;
    private String email;
    private String password;

    // Empty constructor
    public RegisterRequest() {
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}


//Ithu registration data receive cheyyum.
//public class RegisterRequest {
//    private String name;
//    private String email;
//    private String password;}
//Example JSON:
//  { "name": "Zahira",
//  "email": "zay@gmail.com",
//  "password": "123" }
//Ee data RegisterRequest object-il varum.
