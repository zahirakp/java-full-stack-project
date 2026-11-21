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

//Nammal recently create cheytha file aanu.
//Profile response-il password vararuthu ennathinaal aanu ith create cheythath.
//public class ProfileResponse {
//    private Long id;
//    private String name;
//    private String email;  }
//Database-il password undenkilum, ee DTO-il password field illa.
//Athukondu API response-il password varilla.