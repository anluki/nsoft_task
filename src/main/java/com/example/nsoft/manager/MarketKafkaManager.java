package com.example.nsoft.manager;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.nsoft.model.Market;
import com.example.nsoft.services.KafkaSender;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
@Service
public class MarketKafkaManager {
	
	@Autowired
	KafkaSender kafkaSender;
	
	public void sendMarket(Market market) {
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			String marketJson = mapper.writeValueAsString(market);
			kafkaSender.sendMarket( marketJson);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
    public void sendMarket(List<Market> market) {
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			String marketJson = mapper.writeValueAsString(market);
			kafkaSender.sendMarket(marketJson);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
