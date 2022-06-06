package com.example.nsoft.model;

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
@Entity(name = "outcome")
@Table(name = "outcome")
public class Outcome {

	@Id
	@Column(name = "id", unique = true, nullable = false)
	private String id;	
	@JsonIgnore
	@Column(name = "name")
	private String name;
	@Column(name = "status")
    private String status;	
    @ManyToOne
    @JoinColumn(name = "marketId", referencedColumnName = "id")
    @JsonIgnore
    private Market market;
    
    @OneToOne(mappedBy = "outcome")
	@JsonIgnore
    private EventMarketOutcome eventMarketOutcome;

	@Override
	public String toString() {
		return "Outcome [id=" + id + ", name=" + name + ", status=" + status + ", market=" + market
				+ ", eventMarketOutcome=" + eventMarketOutcome + "]";
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
		this.status = Const.STATUS.get(status);
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
	
	
      
}
