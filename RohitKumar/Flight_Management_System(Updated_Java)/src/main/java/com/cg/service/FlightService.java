package com.cg.service;

import java.util.List;

import com.cg.entity.Flight;

public interface FlightService {
	
	 	/* 
	 * Addflight method takes input in an object
	 * And pushes its value to database
	 *  */


	public void addFlight(Flight f);

	 
	 	/* 
	 * Viewflight method will return all the flight details
	 * it calls for an query to get all info
	 *  */

	public List viewFlight();

	 
	 	/* 
	 * Deleteflight is used here to delete any flight details
	 * Flightdetails will be deleted by flight number
	 *  */

	public void deleteFlight(int flightNumber);
	
	 	/* 
	 * Modifyflight will update the flight details
	 * It will search by flight number through out the list
	 * Then it will edit the existing values
	 *  */

	public void modifyFlight(Flight flight);

	 	/* 
	 * This method will simply view a particular airport
	 * By searching flightnumber through out the list
	 *  */

	public Flight viewFlight(int flightNumber);

}
