package com.example.nsoft.model;


import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.example.nsoft.util.Const;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity(name = "event")
@Table(name = "event")
public class Event {

	@Id
	@Column(name = "id", unique = true, nullable = false)
	private String id;
	@Column(name = "name")
	private String name;
	@Column(name = "startsAt")
	private Date startsAt;
	@Column(name = "status")
	private String status;	
	@OneToMany(cascade = CascadeType.ALL)
	private List<EventMarket> markets;
	
	
	@Override
	public String toString() {
		return "Event [id=" + id + ", name=" + name + ", startsAt=" + startsAt + ", status=" + status + ", markets="
				+ markets + "]";
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
	public Date getStartsAt() {
		return startsAt;
	}
	public void setStartsAt(Date startsAt) {
		this.startsAt = startsAt;
	}
	public String getStatus() {
		return  status;
	}
	public void setStatus(String status) {
		this.status = Const.STATUS.get(status);
	}
	public List<EventMarket> getMarkets() {
		return markets;
	}
	public void setMarkets(List<EventMarket> markets) {
		this.markets = markets;
	}
	
}
