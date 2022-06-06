package com.example.nsoft.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.example.nsoft.util.Const;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity(name = "market")
@Table(name = "market")
public class Market {	
	
	@Id
	@Column(name = "id", unique = true, nullable = false)
	private String id;
	@Column(name = "name")
	private String name;
	@Column(name = "status")
	private String status;
	@OneToMany(cascade = CascadeType.ALL)
	@Column(name = "id_outcomes")
	private List<Outcome> outcomes;
	
	@OneToOne(mappedBy = "market")
	@JsonIgnore
    private EventMarket eventMarket;
	
	

	@Override
	public String toString() {
		return "Market [id=" + id + ", name=" + name + ", status=" + status + ", outcomes=" + outcomes
				+ ", eventMarket=" + eventMarket + "]";
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

	public List<Outcome> getOutcomes() {
		return outcomes;
	}

	public void setOutcomes(List<Outcome> outcomes) {
		this.outcomes = outcomes;
	}

	public EventMarket getEventMarket() {
		return eventMarket;
	}

	public void setEventMarket(EventMarket eventMarket) {
		this.eventMarket = eventMarket;
	}
	
	
}
