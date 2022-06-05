package com.example.nsoft.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.nsoft.model.Market;

@Repository
public interface MarketRepositiry extends JpaRepository<Market, String> {
		
	List<Market> findByStatus(String status);
	
	@Query(value = "SELECT * FROM market m, outcome o WHERE m.id = o.id_market AND m.status = ?1 AND o.status = ?1", nativeQuery = true)
	List<Market> findAllActiveMarkets(String status);

}
