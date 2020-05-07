package com.cg.service;

import java.util.List;

import com.cg.entity.Airport;

public interface AirportService {
	
	public void addAirport(Airport a);
	public List viewAirport();
	public Airport viewAirport(String airportCode);

}
