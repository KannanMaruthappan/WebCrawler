package com.webcrawler.ui.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.webcrawler.dao.FlightDetailsModel;
import com.webcrawler.services.FlightService;
import com.webcrawler.ui.model.FlightCriteria;

@RestController
public class FlightServiceController {

	@Autowired
	private FlightService service;
	
	// Find
    @GetMapping("/flightdetails")
    List<FlightDetailsModel> getAllDetails() {
        return service.getAllDetails();
    }

    // Save
    @PostMapping("/flightdetails")
    //return 201 instead of 200
    @ResponseStatus(HttpStatus.CREATED)
    FlightDetailsModel newBook(@RequestBody FlightCriteria criteria) {
        return service.saveFlightDetails(criteria);
    }
    
    //Find
    @GetMapping("/flightdetails/sendoffer")
    List<FlightDetailsModel> sendOffers(@RequestParam String email) {   	
        return service.sendOffers(email);
    }
}
