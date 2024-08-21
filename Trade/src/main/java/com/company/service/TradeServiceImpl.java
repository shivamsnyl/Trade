package com.company.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.entities.Trade;
import com.company.repositoy.TradeRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class TradeServiceImpl implements TradeService {
	
	@Autowired
	TradeRepository repository;

	@Override
	public Trade createTrade(Trade trade) {
		
		trade.setTimeStamp(new Date());
		return repository.save(trade);
	}

	@Override
	public List<Trade> getAllTrades() {
		return repository.findAll();
	}

	@Override
	public Optional<Trade> getTradeById(int id) {
		return repository.findById(id);
	}

	@Override
	public List<Trade> getTradeBySymbol(String symbol) {
		return repository.findBySymbol(symbol);
	}

	@Override
	public List<Trade> getTradeByPrice() {
		List<Trade> trades = repository.findAll();
		return trades.stream().sorted((e1,e2)-> e2.getPrice()-e1.getPrice()).limit(5).toList();
	}

}
