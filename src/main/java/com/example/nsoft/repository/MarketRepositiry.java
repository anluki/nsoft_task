package com.example.nsoft.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.nsoft.model.Market;
import com.example.nsoft.model.Outcome;

@Repository
public interface MarketRepositiry extends JpaRepository<Market, String> {
		
	List<Market> findByStatus(String status);
	
	@Query(value = "select * from"
					+ " market m, market_outcomes mo, outcome o"
					+ " where m.id = mo.market_id"
					+ " and o.id = mo.outcomes_id"
					+ " and m.status = ?1"
					+ " and o.status = ?2", nativeQuery = true)
	List<Market> findAllActiveMarkets(String status, String outcomeStatus);

}
