package com.example.nsoft.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.example.nsoft.util.Const;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity(name = "event_market_outcome")
@Table(name = "event_market_outcome")
public class EventMarketOutcome {
	
	@Id
	@Column(name = "id", unique = true, nullable = false)
	private String id;
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "outcomeId", referencedColumnName = "id")
	@JsonIgnore
	private Outcome outcome;
	@Column(name = "status")
	private String status;
	@Column(name = "odds")
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
		this.status = Const.STATUS.get(status);
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
