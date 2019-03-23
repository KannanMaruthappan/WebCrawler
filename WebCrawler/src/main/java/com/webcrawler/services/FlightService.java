package com.webcrawler.services;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webcrawler.dao.FlightDetailsModel;
import com.webcrawler.dao.FlightServiceDao;
import com.webcrawler.dao.UserDetailsModel;
import com.webcrawler.dao.UserServiceDao;
import com.webcrawler.ui.model.FlightCriteria;

@Service
public class FlightService {

	@Autowired
	private FlightServiceDao dao;
	
	@Autowired
	private UserServiceDao userServiceDao;

	public List<FlightDetailsModel> getAllDetails(){
		return dao.getAll();
	}
	
	public FlightDetailsModel saveFlightDetails(FlightCriteria criteria) {
		return dao.newFlight(new FlightDetailsModel(criteria.getAirportCode(), criteria.getOrg(), criteria.getDes(), criteria.getDate(), criteria.getPrice()));
	}
	
	private void getFlightDetails() {
		//TODO: Crawler to get Flight details needs to be integrated
		//using mock data for testing
		FlightCriteria criteria1 = new FlightCriteria("AC001", "AAA", "BBB", new Date(), new BigDecimal(100.50));
    	FlightCriteria criteria2 = new FlightCriteria("AC002", "BBB", "CCC", new Date(), new BigDecimal(199.50));
    	
    	saveFlightDetails(criteria1);
    	saveFlightDetails(criteria2);
	}
	
    @PostConstruct
    private void initData() {
    	//As the trigger point to get flight details is unknown, data is being pushed post construct
    	getFlightDetails();
    }

	public List<FlightDetailsModel> sendOffers(String email) {
		UserDetailsModel userDetailsModel = userServiceDao.getByEmail(email);
		List<FlightDetailsModel> model = dao.getByOrgAndDes(userDetailsModel.getOrg(), userDetailsModel.getDes());
		sendEmail(model);
		return model;
	}
	
	private void sendEmail(List<FlightDetailsModel> flightDetailsModel) {
		//TODO: Logic to validate frequency and trigger mail accordingly
		System.out.println(flightDetailsModel);
	}
}
