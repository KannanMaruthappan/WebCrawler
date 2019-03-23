package com.webcrawler.dao;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "flight_details")
public class FlightDetailsModel {

	@Id
	@GeneratedValue
	private Long id;
	private String airportCode;
	private String org;
	private String des;
	private Date date;
	private BigDecimal price;

	public FlightDetailsModel() {
		
	}
	
	public FlightDetailsModel(String airportCode, String org, String des, Date date, BigDecimal price) {
		super();
		this.airportCode = airportCode;
		this.org = org;
		this.des = des;
		this.date = date;
		this.price = price;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAirportCode() {
		return airportCode;
	}

	public void setAirportCode(String airportCode) {
		this.airportCode = airportCode;
	}

	public String getOrg() {
		return org;
	}

	public void setOrg(String org) {
		this.org = org;
	}

	public String getDes() {
		return des;
	}

	public void setDes(String des) {
		this.des = des;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "FlightDetailsModel [id=" + id + ", airportCode=" + airportCode + ", org=" + org + ", des=" + des
				+ ", date=" + date + ", price=" + price + "]";
	}

}