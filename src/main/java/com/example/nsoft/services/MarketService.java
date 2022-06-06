package com.example.nsoft.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.nsoft.model.Market;
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
		marketRepositiry.save(market);		
	}
	
	public Market getMarketById (String id) {
		return marketRepositiry.findById(id).get();
	}
	
	public void deleteAll () {
		marketRepositiry.deleteAll();
	}
	
	public List<Market> getAllActiveMarket (String status, String outcomeStatus) {
		return marketRepositiry.findAllActiveMarkets(Const.STATUS.get(status), Const.STATUS.get(outcomeStatus));
	}
}
