package com.example.nsoft.services;

import java.util.Iterator;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.nsoft.model.Market;
import com.example.nsoft.model.Outcome;
import com.example.nsoft.repository.MarketRepositiry;
import com.example.nsoft.repository.OutcomeRepository;
import com.example.nsoft.util.Const;

@Service
@Transactional
public class MarketService {

	@Autowired
	MarketRepositiry marketRepositiry;
	
	@Autowired
	OutcomeRepository outcomeRepository;

	@Autowired
	KafkaSender kafkaSender;
	public void saveMarket(Market market) {
		List<Outcome> outcomes = market.getOutcomes();
		marketRepositiry.save(market);
		for (Iterator iterator = outcomes.iterator(); iterator.hasNext();) {
			Outcome outcome = (Outcome) iterator.next();
			outcome.setIdMarket(market.getId());	
			outcomeRepository.save(outcome);
		}
		
	}
	
	public Market getMarketById (String id) {
		Market market = marketRepositiry.findById(id).get();
		return market;
	}
	
	public void deleteAll () {
		marketRepositiry.deleteAll();
	}
	
	public List<Market> getAllActiveMarket () {
		return marketRepositiry.findByStatus("1");
	}
}
