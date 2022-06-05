package com.example.nsoft.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
public class EventMarket {

	@Id()
	private String id;
	private String status;	
	
	@ManyToOne
    @JoinColumn(name = "eventId")
    @JsonIgnore
	private Event event;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "marketId", referencedColumnName = "id")
	@JsonIgnore
	private Market market;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<EventMarketOutcome> outcomes;

	@Override
	public String toString() {
		return "EventMarket [id=" + id + ", status=" + status + ", event=" + event + ", market=" + market
				+ ", outcomes=" + outcomes + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public Market getMarket() {
		return market;
	}

	public void setMarket(Market market) {
		this.market = market;
	}

	public List<EventMarketOutcome> getOutcomes() {
		return outcomes;
	}

	public void setOutcomes(List<EventMarketOutcome> outcomes) {
		this.outcomes = outcomes;
	}

     


}
