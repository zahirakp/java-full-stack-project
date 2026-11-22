
package com.example.backend.config;

import com.example.backend.service.JwtService;
import com.example.backend.repository.StudentRepository;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

// This class controls security.
@Configuration
public class SecurityConfig {

    // Allows React to connect with Spring Boot.
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration config = new CorsConfiguration();

        // Allows local and deployed React frontend.
        config.setAllowedOrigins(List.of(
                "http://localhost:5173",
                "https://student-management-ruddy-ten.vercel.app"
        ));

        // Allows these request methods.
        config.setAllowedMethods(
                List.of("GET", "POST", "PUT", "DELETE", "OPTIONS")
        );

        // Allows request headers.
        config.setAllowedHeaders(List.of("*"));

        // Allows credentials.
        config.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source =
                new UrlBasedCorsConfigurationSource();

        source.registerCorsConfiguration("/**", config);

        return source;
    }

    // Sets up the security rules.
    @Bean
    public SecurityFilterChain securityFilterChain(
            HttpSecurity http,
            JwtService jwtService,
            StudentRepository studentRepository) throws Exception {

        http
                .cors(cors -> cors.configurationSource(corsConfigurationSource()))
                .csrf(csrf -> csrf.disable())
                .formLogin(form -> form.disable())
                .httpBasic(basic -> basic.disable())

                // Allows registration, login and OPTIONS requests.
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(
                                "/api/auth/register",
                                "/api/auth/login"
                        ).permitAll()
                        .requestMatchers(
                                org.springframework.http.HttpMethod.OPTIONS,
                                "/**"
                        ).permitAll()
                        .anyRequest().authenticated()
                )

                // Adds JWT filter.
                .addFilterBefore(
                        new JwtAuthenticationFilter(
                                jwtService,
                                studentRepository
                        ),
                        UsernamePasswordAuthenticationFilter.class
                );

        return http.build();
    }
}
