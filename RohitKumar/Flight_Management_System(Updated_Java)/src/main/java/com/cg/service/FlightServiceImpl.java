package com.cg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.cg.dao.FlightDao;
import com.cg.entity.Flight;
import com.cg.error.UserCreatedException;

@Service
public class FlightServiceImpl implements FlightService {
	
	@Autowired
	FlightDao flightDao;
	

	 	/* 
	 * Addflight method takes input in an object
	 * And pushes its value to database
	 *  */

	@Override
	public void addFlight(Flight f) throws UserCreatedException{
		
		try
		{
			flightDao.addFlight(f);
		}
		catch(DataIntegrityViolationException e)
		{
			throw new UserCreatedException("Flight no already Exists");
		}

	}

	 
	 	/* 
	 * Viewflight method will return all the flight details
	 * it calls for an query to get all info
	 *  */

	@Override
	public List viewFlight() {

		return flightDao.viewFlight();
	}

	 
	 	/* 
	 * Deleteflight is used here to delete any flight details
	 * Flightdetails will be deleted by flight number
	 *  */

	@Override
	public void deleteFlight(int flightNumber) {
		

		Flight fli=flightDao.viewFlight(flightNumber);
		if(fli!=null)
		flightDao.deleteFlight(flightNumber);
		else
			throw new RuntimeException("Flight Number not found");
	}

	 	/* 
	 * Modifyflight will update the flight details
	 * It will search by flight number through out the list
	 * Then it will edit the existing values
	 *  */

	@Override
	public void modifyFlight(Flight flight) {

		flightDao.modifyFlight(flight);
		
	}

	 
	 	/* 
	 * This method will simply view a particular airport
	 * By searching flightnumber through out the list
	 *  */

	@Override
	public Flight viewFlight(int flightNumber) throws UserCreatedException{
		

		Flight flight=flightDao.viewFlight(flightNumber);
		if(flight!=null)
		{
			return flight;
		}
		else
			throw new UserCreatedException("Flight number not found");
		
	}

}
