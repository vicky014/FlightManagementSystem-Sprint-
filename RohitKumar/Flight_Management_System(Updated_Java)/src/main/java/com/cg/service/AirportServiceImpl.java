package com.cg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.cg.dao.AirportDao;
import com.cg.entity.Airport;
import com.cg.entity.Flight;
import com.cg.error.UserCreatedException;

@Service
public class AirportServiceImpl implements AirportService{
	
	@Autowired
	AirportDao airportDao;

	/* 
	 * Addairport method takes input in an object
	 * And pushes its value to database
	 *  */


	@Override
	public void addAirport(Airport a) throws UserCreatedException{

		try {
			airportDao.addAirport(a);

			}
		catch(DataIntegrityViolationException e)
			{
				throw new UserCreatedException("Airport code already Exists");
			}
	}

	 
	 	/* 
	 * Viewairport method will return all the airport details
	 * it calls for an query to get all info
	 *  */

	@Override
	public List viewAirport() {
		
		return airportDao.viewAirport();
	}

	 	/* 
	 * This method will simply view a particular airport
	 * By searching airportcode through out the list
	 *  */

	@Override
	public Airport viewAirport(String airportCode) throws UserCreatedException{

		Airport airport=airportDao.viewAirport(airportCode);
		if(airport!=null)
		{
			return airport;
		}
		else
			throw new UserCreatedException("Airport code not found");
		
	
	}
	
	

}
