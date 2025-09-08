package com.example.portfolioManagement.portfolio.controller;

import com.example.portfolioManagement.portfolio.entities.User;
import com.example.portfolioManagement.portfolio.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TestDataController {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @GetMapping("/test-users")
    public ResponseEntity<String> seedUser() {
        return userRepository.findByUsername("demo")
                .<ResponseEntity<String>>map(u -> ResponseEntity.ok("User already exists: demo/demo123"))
                .orElseGet(() -> {
                    User user = new User();
                    user.setUsername("demo");
                    user.setEmail("demo@example.com");
                    user.setPasswordHash(passwordEncoder.encode("demo123"));
                    userRepository.save(user);
                    return ResponseEntity.ok("Created user demo/demo123");
                });
    }
}


