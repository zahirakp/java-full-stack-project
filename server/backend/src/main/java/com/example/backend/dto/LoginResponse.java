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

// When login is successful, the backend returns a JWT token.
// LoginResponse stores the token.

//public class LoginResponse {
//    private String token;
//}

// Example response:
// {
//     "token": "your-jwt-token"
// }

// The frontend can save this token.
// Later, the frontend sends this token when calling protected APIs.