package com.example.backend.dto;

// This class sends profile details.
public class ProfileResponse {

    private Long id;
    private String name;
    private String email;

    // Gets and sets the values.
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
}

// This is a file we created recently.
// We created this because the password should not appear in the profile response.

//public class ProfileResponse {
//    private Long id;
//    private String name;
//    private String email;
//}

// Even though the password exists in the database,
// this DTO does not have a password field.
// So, the password will not appear in the API response.