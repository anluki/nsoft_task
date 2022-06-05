package com.example.nsoft.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.nsoft.model.Event;
import com.example.nsoft.model.EventMarket;
import com.example.nsoft.model.Market;
import com.example.nsoft.model.Outcome;
import com.example.nsoft.services.EventMarketService;
import com.example.nsoft.services.EventService;
import com.example.nsoft.services.KafkaSender;
import com.example.nsoft.services.MarketService;
import com.example.nsoft.services.OutcomeService;

@RestController
@RequestMapping("/nsoft")
public class NsoftController {
	
	@Autowired
	KafkaSender kafkaSender;
	
	@Autowired
	MarketService marketService;
	
	@Autowired
	OutcomeService outcomeService;
	
	@Autowired
	EventService eventService;
	
	@Autowired
	EventMarketService eventMarketService;
	
	@GetMapping(value = "/test")
	public String test () {
		return "Radi REST poziv metode test";
	}
			
//	@GetMapping(value = "/kafka_test")
//	public String producer(@RequestParam("message") String message) {
//		kafkaSender.send("test", message);
//		return "Message sent to the Kafka Topic java_in_use_topic Successfully";
//	}
	
	@GetMapping("/getMarketById/{id}")
    public Market getMarketById(@PathVariable(value = "id") String id) {
		return marketService.getMarketById(id);
    }
	
	@GetMapping("/getOutcomeById/{id}")
    public Outcome getOutcomeById(@PathVariable(value = "id") String id) {
		return outcomeService.getOutcomeById(id);
    }
	
	@GetMapping("/getAllOutcome")
    public List<Outcome> getAllOutcome() {
		return outcomeService.getAllOutcome();
    }
		
	@GetMapping("/getEventById/{id}")
    public Event getEventById(@PathVariable(value = "id") String id) {
		return eventService.getEventById(id);
    }
	
	@GetMapping("/getEventMarketById/{id}")
    public EventMarket getEventMarketById(@PathVariable(value = "id") String id) {
		return eventMarketService.getEventMarketById(id);
    }
	
	@PostMapping("/updateEvent")
    public Event updateEvent(@RequestBody Event event) {
       return eventService.saveEvent(event);
    }
	
	@PostMapping("/updateMarket")
    public void updateMarket(@RequestBody Market market) {
       marketService.saveMarket(market);
    }
	
	
	@GetMapping("/getAllActiveMarket")
    public List<Market> getAllActiveMarket() {
		return marketService.getAllActiveMarket();
    }
	
	
}
