package com.cg.dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cg.entity.Flight;

@Transactional
@Repository

public class FlightDaoImpl implements FlightDao{
	
	@PersistenceContext
	EntityManager em;

	/* 
	 * Addflight method takes input in an object
	 * And pushes its value to database
	 *  */
	
	@Override
	public void addFlight(Flight f) {
		em.persist(f);
	}

	/* 
	 * Viewflight method will return all the flight details
	 * it calls for an query to get all info
	 *  */
	
	@Override
	public List viewFlight() {
		
		Query q=em.createQuery("from Flight f");
		return q.getResultList();
		
	}
	
	/* 
	 * Deleteflight is used here to delete any flight details
	 * Flightdetails will be deleted by flight number
	 *  */

	@Override
	public void deleteFlight(int flightNumber) {
		
		Flight f=em.find(Flight.class, flightNumber);
		System.out.println(f.getFlightNumber() +" "+f.getFlightModel() + " "+f.getSeatCapacity()+" "+f.getCarrierName()+ " is removed");
		em.remove(f);
		
	}

	/* 
	 * Modifyflight will update the flight details
	 * It will search by flight number through out the list
	 * Then it will edit the existing values
	 *  */
	
	@Override
	public void modifyFlight(Flight flight) {
		
		Flight fly=em.find(Flight.class, flight.getFlightNumber());
		fly.setFlightModel(flight.getFlightModel());
		fly.setFlightNumber(flight.getFlightNumber());
		fly.setCarrierName(flight.getCarrierName());
		fly.setSeatCapacity(flight.getSeatCapacity());
		System.out.println("Updated");
		
	}

	/* 
	 * This method will simply view a particular airport
	 * By searching flightnumber through out the list
	 *  */
	
	@Override
	public Flight viewFlight(int flightNumber) {

		
		return em.find(Flight.class,  flightNumber);
		
	}

}
