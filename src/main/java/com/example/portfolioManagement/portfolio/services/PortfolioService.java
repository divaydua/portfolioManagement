package com.example.portfolioManagement.portfolio.services;

import com.example.portfolioManagement.portfolio.dto.HoldingDto;
import com.example.portfolioManagement.portfolio.entities.Asset;
import com.example.portfolioManagement.portfolio.entities.Holding;
import com.example.portfolioManagement.portfolio.entities.User;
import com.example.portfolioManagement.portfolio.repositories.AssetRepository;
import com.example.portfolioManagement.portfolio.repositories.HoldingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PortfolioService {
    private final HoldingRepository holdingRepository;
    private final AssetRepository assetRepository;

    public Holding addHolding(User user, HoldingDto dto) {
        Asset asset = assetRepository.findBySymbol(dto.symbol())
                .orElseGet(() -> assetRepository.save(new Asset(null, dto.symbol(), dto.symbol(), "stock")));

        Holding holding = new Holding();
        holding.setUser(user);
        holding.setAsset(asset);
        holding.setQuantity(dto.quantity());
        holding.setBuyPrice(dto.buyPrice());

        return holdingRepository.save(holding);
    }

    public List<Holding> getHoldings(User user) {
        return holdingRepository.findByUser(user);
    }
}