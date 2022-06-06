package com.example.nsoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.nsoft.services.KafkaSender;

@RestController
@RequestMapping("/nsoft")
public class NsoftController {
	
	@Autowired
	KafkaSender kafkaSender;
	
	
	
	@GetMapping(value = "/test")
	public String test () {
		return "Radi REST poziv metode test";
	}
			
	@GetMapping(value = "/kafkaTest")
	public String kafkaTest(@RequestParam("message") String message) {
		kafkaSender.send("test", message);
		return "Message sent to the Kafka Topic event Successfully";
	}
	
	
}
