package com.company.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.entities.Trade;
import com.company.service.TradeService;

@RestController
@RequestMapping("/trade")
public class TradeController {
	
	@Autowired
	private TradeService service;
	
	
	@PostMapping("/create")
	public ResponseEntity<Trade> createTrade(@org.springframework.web.bind.annotation.RequestBody Trade t){
		
		Trade t1= service.createTrade(t);
		return new ResponseEntity<>(t1,HttpStatus.CREATED);
	}
	
	@GetMapping("/getAllTrades")
	public ResponseEntity<List<Trade>> getAllTrades(){
		
		List<Trade> t1= service.getAllTrades();
		return new ResponseEntity<>(t1,HttpStatus.OK);
	}
	
	@GetMapping("/getTrade/{id}")
	public ResponseEntity<Optional<Trade>> getTradeByID(@PathVariable int id){
		
		Optional<Trade> t1= service.getTradeById(id);
		if(t1.isPresent())
		return new ResponseEntity<>(t1,HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/getTradeBySymbol/{symbol}")
	public ResponseEntity<List<Trade>> getTradeSymbol(@PathVariable String symbol){
		
		List<Trade> t1= service.getTradeBySymbol(symbol);
		if(!t1.isEmpty())
		return new ResponseEntity<>(t1,HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@GetMapping("/getTradesByPrice")
	public ResponseEntity<List<Trade>> getTradesByPrice(){
		
		List<Trade> t1= service.getTradeByPrice();
		if(t1 != null)
		return new ResponseEntity<>(t1,HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/getTrade/{id}")
	public ResponseEntity<Trade> deleteTradeById(@PathVariable int id){
		
			return new ResponseEntity<>(HttpStatus.METHOD_NOT_ALLOWED);
	}
	
	@PutMapping("/getTrade/{id}")
	public ResponseEntity<Trade> modifyTradeById(@PathVariable int id){
		
			return new ResponseEntity<>(HttpStatus.METHOD_NOT_ALLOWED);
	}
	
	@PatchMapping("/getTrade/{id}")
	public ResponseEntity<Trade> modifyTrade(@PathVariable int id){
		
			return new ResponseEntity<>(HttpStatus.METHOD_NOT_ALLOWED);
	}

}
