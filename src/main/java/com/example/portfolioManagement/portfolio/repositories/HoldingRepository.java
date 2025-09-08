package com.example.portfolioManagement.portfolio.repositories;

import com.example.portfolioManagement.portfolio.entities.Holding;
import com.example.portfolioManagement.portfolio.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HoldingRepository extends JpaRepository<Holding, Long> {
    List<Holding> findByUser(User user);
}
