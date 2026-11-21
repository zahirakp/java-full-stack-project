package com.example.backend.dto;

// This class sends the login token.
public class LoginResponse {

    private String token;

    // Creates an empty response.
    public LoginResponse() {
    }

    // Gets the token.
    public String getToken() {
        return token;
    }

    // Sets the token.
    public void setToken(String token) {
        this.token = token;
    }
}

//Login successful aayal backend JWT token return cheyyum.
//LoginResponse-il token store cheyyunnu.
//public class LoginResponse {
//    private String token;}

//Example response:
// { "token": "your-jwt-token" }
//Ithu frontend-il save cheyyan kazhiyum. Pinne protected API call cheyyumbol token send cheyyum.