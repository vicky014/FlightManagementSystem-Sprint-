package com.cg.dao;

import java.util.List;

import com.cg.entity.Airport;


public interface AirportDao {

	public void addAirport(Airport a);
	public List viewAirport();
	public Airport viewAirport(String airportCode);

}
