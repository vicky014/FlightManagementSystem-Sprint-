package com.cg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dao.AirportDao;
import com.cg.entity.Airport;

@Service
public class AirportServiceImpl implements AirportService{
	
	@Autowired
	AirportDao airportDao;

	@Override
	public void addAirport(Airport a) {

		airportDao.addAirport(a);
		
	}

	@Override
	public List viewAirport() {
		
		return airportDao.viewAirport();
	}

	@Override
	public Airport viewAirport(String airportCode) {

		return airportDao.viewAirport(airportCode);
	}
	
	

}
