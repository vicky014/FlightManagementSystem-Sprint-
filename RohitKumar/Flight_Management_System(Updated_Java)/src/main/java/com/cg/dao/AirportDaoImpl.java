package com.cg.dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cg.entity.Airport;

@Transactional
@Repository
public class AirportDaoImpl implements AirportDao{
	
	@PersistenceContext
	EntityManager em1;

	/* 
	 * Addairport method takes input in an object
	 * And pushes its value to database
	 *  */
	
	@Override
	public void addAirport(Airport a) {

		em1.persist(a);
	}
	
	/* 
	 * Viewairport method will return all the airport details
	 * it calls for an query to get all info
	 *  */

	@Override
	public List viewAirport() {

		Query q1=em1.createQuery("from Airport a");
		return q1.getResultList();
	}
	
	/* 
	 * This method will simply view a particular airport
	 * By searching airportcode through out the list
	 *  */

	@Override
	public Airport viewAirport(String airportCode) {
			return em1.find(Airport.class, airportCode);
	}

}
