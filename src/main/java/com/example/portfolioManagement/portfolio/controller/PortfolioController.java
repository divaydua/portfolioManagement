package com.example.portfolioManagement.portfolio.controller;

import com.example.portfolioManagement.portfolio.dto.HoldingDto;
import com.example.portfolioManagement.portfolio.entities.Holding;
import com.example.portfolioManagement.portfolio.entities.User;
import com.example.portfolioManagement.portfolio.repositories.UserRepository;
import com.example.portfolioManagement.portfolio.services.PortfolioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/portfolio")
@RequiredArgsConstructor
public class PortfolioController {
    private final PortfolioService portfolioService;
    private final UserRepository userRepository;

    @PostMapping("/add")
    public ResponseEntity<Holding> addHolding(@RequestBody HoldingDto dto) {
        User user = userRepository.findById(1L).orElseThrow(); // TEMP: fixed user
        return ResponseEntity.ok(portfolioService.addHolding(user, dto));
    }

    @GetMapping
    public ResponseEntity<List<Holding>> getHoldings() {
        User user = userRepository.findById(1L).orElseThrow(); // TEMP: fixed user
        return ResponseEntity.ok(portfolioService.getHoldings(user));
    }
}