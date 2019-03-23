package com.webcrawler.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FlightServiceDao {

	@Autowired
	private FlightRepository repository;
	
	public FlightDetailsModel newFlight(FlightDetailsModel flight) {
		return repository.save(flight);
	}
	
	public List<FlightDetailsModel> getAll(){
		return repository.findAll();
	}
	
	public List<FlightDetailsModel> getByOrgAndDes(String org, String des){
		return repository.findByOrgAndDes(org, des);
	}
}
