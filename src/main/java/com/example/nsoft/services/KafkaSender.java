package com.example.nsoft.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.example.nsoft.model.Event;
import com.example.nsoft.model.Market;

@Service
public class KafkaSender {
	
	@Autowired
	private KafkaTemplate<String, List<Event>> kafkaEventTemplate;
	
	@Autowired
	private KafkaTemplate<String,  List<Market>> kafkaMarketTemplate;
		
	public void sendEvent(String kafkaTopic, List<Event> event) {
		kafkaEventTemplate.send(kafkaTopic, event);
	}
	
	public void sendMarket(String kafkaTopic,  List<Market> market) {
		kafkaMarketTemplate.send(kafkaTopic, market);
	}
}