package com.example.portfolioManagement.portfolio.services;

import com.example.portfolioManagement.portfolio.entities.User;
import com.example.portfolioManagement.portfolio.dto.LoginDto;
import com.example.portfolioManagement.portfolio.dto.SignupDto;
import com.example.portfolioManagement.portfolio.repositories.UserRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public User signup(SignupDto dto) {
        User user = new User();
        user.setUsername(dto.username());
        user.setEmail(dto.email());
        user.setPasswordHash(passwordEncoder.encode(dto.password()));
        return userRepository.save(user);
    }

    public String login(LoginDto dto) {
        // For MVP: just return dummy token after user exists
        User user = userRepository.findByUsername(dto.username())
                .orElseThrow(() -> new RuntimeException("User not found"));
        if (!passwordEncoder.matches(dto.password(), user.getPasswordHash())) {
            throw new RuntimeException("Invalid credentials");
        }
        return "dummy-jwt-token"; // später ersetzen mit JWT
    }
}
