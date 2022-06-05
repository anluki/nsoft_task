package com.example.nsoft.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.nsoft.model.EventMarket;
import com.example.nsoft.repository.EventMarketRepository;

@Service
public class EventMarketService {

	@Autowired
	EventMarketRepository eventMarketRepository;

	public EventMarket getEventMarketById(String id) {		
		return eventMarketRepository.findById(id).get();
	}
	
	
	
}
