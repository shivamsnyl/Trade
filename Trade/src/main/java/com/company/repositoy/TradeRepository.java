package com.company.repositoy;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.company.entities.Trade;

@Repository
public interface TradeRepository extends JpaRepository<Trade, Integer>{

	List<Trade> findBySymbol(String symbol);

}
