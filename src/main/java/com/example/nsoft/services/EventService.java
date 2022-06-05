package com.example.nsoft.services;



import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.nsoft.model.Event;
import com.example.nsoft.model.Market;
import com.example.nsoft.repository.EventRepository;

@Service()
@Transactional
public class EventService {
	
	@Autowired
	EventRepository eventRepository;
	
	@Autowired
	KafkaSender kafkaSender;

	 public Event saveEvent(Event event) {
        Event e =  eventRepository.save(event);
        return e;
     }
	
	 public Event getEventById (String id) {
		Event event = eventRepository.findById(id).get();
		return event;
	}
		
	public void deleteAll () {
		eventRepository.deleteAll();
	}
	
	public List<Event> getAllEvent () {
		return eventRepository.findAll();
	}
}
