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

	@Override
	public void addFlight(Flight f) {
		em.persist(f);
	}

	@Override
	public List viewFlight() {
		
		Query q=em.createQuery("from Flight f");
		return q.getResultList();
		
	}

	@Override
	public void deleteFlight(long FlightNumber) {
		
		Flight f=em.find(Flight.class, FlightNumber);
		System.out.println(f.getFlightNumber() +" "+f.getFlightModel() + " "+f.getSeatCapacity()+" "+f.getCarrierName()+ " is removed");
		em.remove(f);
		
	}

	@Override
	public Flight modifyFlight(long FlightNumber) {
		
		Flight fly=em.find(Flight.class, FlightNumber);
		fly.setSeatCapacity(23);
		System.out.println("Updated");
		return null;
	}

	@Override
	public Flight viewFlight(long FlightNumber) {

		
		return em.find(Flight.class,  FlightNumber);
		
	}

}
