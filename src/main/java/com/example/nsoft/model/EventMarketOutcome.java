package com.example.nsoft.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name = "eventMarketOutcome")
public class EventMarketOutcome {
	
	@Id
	private String id;
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "outcomeId", referencedColumnName = "id")
	@JsonIgnore
	private Outcome outcome;
	private String status;
	private Double odds;
	
	@ManyToOne
    @JoinColumn(name = "eventMarketId", referencedColumnName = "id")
    @JsonIgnore
	private EventMarket eventMarket;

	@Override
	public String toString() {
		return "EventMarketOutcome [id=" + id + ", outcome=" + outcome + ", status=" + status + ", odds=" + odds
				+ ", eventMarket=" + eventMarket + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Outcome getOutcome() {
		return outcome;
	}

	public void setOutcome(Outcome outcome) {
		this.outcome = outcome;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Double getOdds() {
		return odds;
	}

	public void setOdds(Double odds) {
		this.odds = odds;
	}

	public EventMarket getEventMarket() {
		return eventMarket;
	}

	public void setEventMarket(EventMarket eventMarket) {
		this.eventMarket = eventMarket;
	}

}
