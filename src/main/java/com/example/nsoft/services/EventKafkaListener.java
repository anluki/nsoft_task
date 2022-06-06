package com.example.nsoft.services;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class EventKafkaListener {
	
	@KafkaListener(topics = {"event","market"})
    public void processMessage(String content){
        System.out.println("Message received: " + content);
    }

}
