package com.example.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

}

//how the back end works

//Student enters details on the website.
//Frontend sends the details to the backend.
//Controller receives the request.
//Service does the required work.
//Repository communicates with MySQL.
//MySQL saves or provides the data.
//Backend sends the result to the frontend.