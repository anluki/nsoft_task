package com.example.nsoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.nsoft.manager.EventKafkaManager;
import com.example.nsoft.model.Event;
import com.example.nsoft.model.EventMarket;
import com.example.nsoft.services.EventMarketService;
import com.example.nsoft.services.EventService;

@RestController
@RequestMapping("/nsoft/event")
public class EventController {

	@Autowired
	EventService eventService;
	
	@Autowired
	EventMarketService eventMarketService;
	
	@Autowired
	EventKafkaManager eventKafkaManager;
	
	@PostMapping("/kafkaEvent")
    public String kafkaEvent(@RequestBody Event event) {
	   eventKafkaManager.sendEvent(event);
       return "Message sent to the Kafka Topic event Successfully";
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
}
