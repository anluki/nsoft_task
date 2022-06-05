package com.example.nsoft.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.nsoft.model.Market;
import com.example.nsoft.model.Outcome;
import com.example.nsoft.repository.OutcomeRepository;

@Service
public class OutcomeService {
	
	@Autowired
	OutcomeRepository outcomeRepository;

	public void saveOutcome (Outcome outcome) {
		outcomeRepository.save(outcome);
	}
	
	public void deleteAll () {
		outcomeRepository.deleteAll();
	}
	
	public Outcome getOutcomeById (String id) {
		Outcome outcome = outcomeRepository.findById(id).get();
		return outcome;
	}
	
	public List<Outcome> getAllOutcome () {
		List<Outcome> outcomeList = outcomeRepository.findAll();
		return outcomeList;
	}
}
