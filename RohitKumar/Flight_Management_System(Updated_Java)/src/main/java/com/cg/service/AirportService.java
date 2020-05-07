package com.cg.service;

import java.util.List;

import com.cg.entity.Airport;

public interface AirportService {
	
	/* 
	 * Addairport method takes input in an object
	 * And pushes its value to database
	 *  */
	 

	public void addAirport(Airport a);

	 	/* 
	 * Viewairport method will return all the airport details
	 * it calls for an query to get all info
	 *  */

	public List viewAirport();


	 
	 	/* 
	 * This method will simply view a particular airport
	 * By searching airportcode through out the list
	 *  */

	public Airport viewAirport(String airportCode);

}
