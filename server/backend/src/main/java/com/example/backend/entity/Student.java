
package com.example.backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String email;
    private String password;

    // Empty constructor
    public Student() {
    }

    // Getters and Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
//@Entity
//Ithu Java class aanu database table represent cheyyunnath ennu Spring/JPA-ne ariyikkunnu.
//@Id
//Ithu table-il primary key aanu.
//Primary key ennu paranjaal oro student-inum unique aaya ID.

//@GeneratedValue
//ID automatic aayi generate cheyyum.

//private String password
//Student password store cheyyan. Nammal database-il plain password alla, BCrypt hash aanu save cheyyunnath.