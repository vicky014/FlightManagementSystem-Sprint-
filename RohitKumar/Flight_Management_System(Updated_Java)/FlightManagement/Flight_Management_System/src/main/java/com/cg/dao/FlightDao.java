package com.cg.dao;

import java.util.List;

import com.cg.entity.Flight;

public interface FlightDao {

	
	public void addFlight(Flight f);
	public List viewFlight();
	public void deleteFlight(long FlightNumber);
	
	public Flight modifyFlight(long FlightNumber);
	public Flight viewFlight(long FlightNumber);
}
