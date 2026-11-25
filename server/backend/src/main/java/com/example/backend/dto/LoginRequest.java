
package com.example.backend.dto;

// This class gets login details.
public class LoginRequest {

    private String email;
    private String password;

    // Empty constructor.
    public LoginRequest() {
    }

    // Gets the email.
    public String getEmail() {
        return email;
    }

    // Sets the email.
    public void setEmail(String email) {
        this.email = email;
    }

    // Gets the password.
    public String getPassword() {
        return password;
    }

    // Sets the password.
    public void setPassword(String password) {
        this.password = password;
    }
}

// During login, we don't need the student's name.
// We only need the email and password.

//public class LoginRequest {

//    private String email;
//    private String password;
//}

// Example:
// {
//     "email": "zay@gmail.com",
//     "password": "123"
// }