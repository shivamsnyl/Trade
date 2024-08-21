package com.company.service;

import java.util.List;
import java.util.Optional;

import com.company.entities.Trade;

public interface TradeService {
	
	Trade createTrade(Trade trade);
	List<Trade> getAllTrades();
	Optional<Trade> getTradeById(int id);
	List<Trade> getTradeBySymbol(String symbol);
	List<Trade> getTradeByPrice();

}
