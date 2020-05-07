package com.cg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dao.FlightDao;
import com.cg.entity.Flight;

@Service
public class FlightServiceImpl implements FlightService {
	
	@Autowired
	FlightDao flightDao;
	

	@Override
	public void addFlight(Flight f) {

		flightDao.addFlight(f);
	}

	@Override
	public List viewFlight() {

		return flightDao.viewFlight();
	}

	@Override
	public void deleteFlight(long FlightNumber) {
		

		Flight fli=flightDao.viewFlight(FlightNumber);
		if(fli!=null)
		flightDao.deleteFlight(FlightNumber);
		else
			throw new RuntimeException("No Flight Number found");
	}

	@Override
	public Flight modifyFlight(long FlightNumber) {

		return flightDao.modifyFlight(FlightNumber);
		
	}

	@Override
	public Flight viewFlight(long FlightNumber) {

		return flightDao.viewFlight(FlightNumber);
		
	}

}
