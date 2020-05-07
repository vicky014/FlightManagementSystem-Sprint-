package com.cg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.Airport;
import com.cg.entity.Flight;
import com.cg.service.AirportService;
import com.cg.service.FlightService;

@CrossOrigin(origins="http://localhost:4200")
@RestController

public class FMSController {
	
	@Autowired
	FlightService flightService;
	
	
	//Flight Functionalities
	
@GetMapping(value="/flight")
public List<Flight> fetchFlight()
{
	return flightService.viewFlight();
}

@GetMapping(value="/flight/{flightNumber}")
public Flight fetchOne(@PathVariable int flightNumber)
{
	return flightService.viewFlight(flightNumber);	
}

@PostMapping(value="/flight/new", consumes= {"application/json"})
public String AddFlight(@RequestBody Flight flight)
{
	flightService.addFlight(flight);
	return "Flight Added";
}

@DeleteMapping(value="/flight/delete/{flightNumber}")
public String DeleteFlight(@PathVariable int flightNumber)
{
	flightService.deleteFlight(flightNumber);
	return "Flight Deleted";
}

 @PutMapping(value="/flight/modify/", consumes= {"application/json"})
public String ModifyFlight(@RequestBody Flight flight)
{
	flightService.modifyFlight(flight);
	return "Flight Modified";
}

	//Airport Functionalities

	@Autowired
	AirportService airportService;

	@GetMapping(value="/airport")
	public List<Airport> fetchAirport()
	{
		return airportService.viewAirport();
		
	}

	@GetMapping(value="/airport/{airportCode}")
	public Airport fetchTwo(@PathVariable String airportCode)
	{
		return airportService.viewAirport(airportCode);	
	}

	@PostMapping(value="/airport/new", consumes= {"Application/json"})
	public String AddAirport(@RequestBody Airport airport)
	{
		airportService.addAirport(airport);
		return "Airport Added";
		
	}
		

}
