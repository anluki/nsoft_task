package com.example.nsoft.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.nsoft.model.Event;
import com.example.nsoft.services.KafkaSender;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class EventKafkaManager {
	@Autowired
	KafkaSender kafkaSender;

	public void sendEvent(Event event) {
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			String eventJson = mapper.writeValueAsString(event);
			kafkaSender.sendEvent(eventJson);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
     public void sendEvent(List<Event> event) {
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			String eventJson = mapper.writeValueAsString(event);
			kafkaSender.sendEvent(eventJson);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
