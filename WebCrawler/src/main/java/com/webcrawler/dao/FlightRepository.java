package com.webcrawler.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<FlightDetailsModel, Long> {

	List<FlightDetailsModel> findByOrgAndDes(String org, String des);
}
