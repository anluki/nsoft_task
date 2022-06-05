package com.example.nsoft.services;




import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

import com.example.nsoft.model.Event;
import com.example.nsoft.model.EventMarket;
import com.example.nsoft.model.Market;
import com.example.nsoft.model.Outcome;
import com.example.nsoft.util.Const;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


@Service
public class InitialValuesService implements ApplicationRunner{
	
	@Value("${json.folder}")
    String jsonFolder;
	
	@Autowired
	EventService eventService;
	
	@Autowired
	MarketService marketService;
	
	@Autowired
	OutcomeService outcomeService;
	
	private final static String  MARKETS_FILENAME_JSON = "markets.json";
	private final static String  EVENTS_FILENAME_JSON = "events.json";
	
	public void init() {
		try {
			System.out.println("Evo me try u initial values");
			ObjectMapper mapper = new ObjectMapper();
			String jsonMarkets = new String(Files.readAllBytes(Paths.get(jsonFolder + MARKETS_FILENAME_JSON)));
			String jsonEvents = new String(Files.readAllBytes(Paths.get(jsonFolder + EVENTS_FILENAME_JSON)));
		
			
			List<Market> markets = mapper.reader()
				      .forType(new TypeReference<List<Market>>() {})
				      .readValue(jsonMarkets);

			for (Iterator iterator = markets.iterator(); iterator.hasNext();) {
				Market market = (Market) iterator.next();
				marketService.saveMarket(market);				
			}
			
			List<Event> events = mapper.reader()
				      .forType(new TypeReference<List<Event>>() {})
				      .readValue(jsonEvents);
						
			for (Iterator iterator = events.iterator(); iterator.hasNext();) {
				Event event = (Event) iterator.next();				
				eventService.saveEvent(event);
			}
			
			
			
		} catch (Exception e) {
			System.out.println("ERROR=" + e.getMessage());
		}
		
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		init();
	}

}
