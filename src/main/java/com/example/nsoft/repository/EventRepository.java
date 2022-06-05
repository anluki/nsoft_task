package com.example.nsoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.nsoft.model.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, String> {
	
}
	
	