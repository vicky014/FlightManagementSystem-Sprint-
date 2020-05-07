package com.cg.service;

import java.util.List;

import com.cg.entity.Flight;

public interface FlightService {
	
	public void addFlight(Flight f);
	public List viewFlight();
	public void deleteFlight(long FlightNumber);
	
	public Flight modifyFlight(long FlightNumber);
	public Flight viewFlight(long FlightNumber);

}
