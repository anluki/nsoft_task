package com.example.nsoft.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaSender {
	
	final private static String MARKET_TOPIC = "market"; 
	final private static String EVENT_TOPIC = "event"; 
	
	@Autowired
	private KafkaTemplate<String, String> kafkaEventTemplate;
	
	@Autowired
	private KafkaTemplate<String, String> kafkaMarketTemplate;
	
	@Autowired
	private KafkaTemplate<String,  String> kafkaTestTemplate;
	
	
		
	public void sendEvent(String event) {
		kafkaEventTemplate.send(EVENT_TOPIC, event);
	}
	
	public void sendMarket(String market) {
		kafkaMarketTemplate.send(MARKET_TOPIC, market);
	}

	public void send(String string, String message) {
		kafkaTestTemplate.send(string, message);
	}
}