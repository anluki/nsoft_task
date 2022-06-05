package com.example.nsoft.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
public class Outcome {

	@Id
	private String id;	
	@JsonIgnore
	private String name;
    private String status;	
    @ManyToOne
    @JoinColumn(name = "marketId")
    @JsonIgnore
    private Market market;
    
    @OneToOne(mappedBy = "outcome")
	@JsonIgnore
    private EventMarketOutcome eventMarketOutcome;
    private String idMarket;
	@Override
	public String toString() {
		return "Outcome [id=" + id + ", name=" + name + ", status=" + status + ", market=" + market
				+ ", eventMarketOutcome=" + eventMarketOutcome + ", idMarket=" + idMarket + "]";
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Market getMarket() {
		return market;
	}
	public void setMarket(Market market) {
		this.market = market;
	}
	public EventMarketOutcome getEventMarketOutcome() {
		return eventMarketOutcome;
	}
	public void setEventMarketOutcome(EventMarketOutcome eventMarketOutcome) {
		this.eventMarketOutcome = eventMarketOutcome;
	}
	public String getIdMarket() {
		return idMarket;
	}
	public void setIdMarket(String idMarket) {
		this.idMarket = idMarket;
	}
    
    
  
      
}
