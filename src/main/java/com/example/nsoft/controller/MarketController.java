package com.example.nsoft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.nsoft.manager.MarketKafkaManager;
import com.example.nsoft.model.Market;
import com.example.nsoft.services.MarketService;

@RestController
@RequestMapping("/nsoft/market")
public class MarketController {
	
	@Autowired
	MarketService marketService;
	
	@Autowired
	MarketKafkaManager marketKafkaManager;
	
	
	@PostMapping("/kafkaMarket")
    public String kafkaEvent(@RequestBody Market market) {
		marketKafkaManager.sendMarket(market);
       return "Message sent to the Kafka Topic market Successfully";
    }
	
	@GetMapping("/getMarketById/{id}")
    public Market getMarketById(@PathVariable(value = "id") String id) {
		return marketService.getMarketById(id);
    }
		
	@PostMapping("/updateMarket")
    public void updateMarket(@RequestBody Market market) {
       marketService.saveMarket(market);
    }
	
	
	@GetMapping("/getAllActiveMarket/{status}/{outcomeStatus}")
    public List<Market> getAllActiveMarket(@PathVariable(value = "status") String status, @PathVariable(value = "outcomeStatus") String outcomeStatus) {
		return marketService.getAllActiveMarket(status, outcomeStatus);
    }

}
