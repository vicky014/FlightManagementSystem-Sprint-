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

	@Override
	public void addAirport(Airport a) {

		em1.persist(a);
	}

	@Override
	public List viewAirport() {

		Query q1=em1.createQuery("from Airport a");
		return q1.getResultList();
	}

	@Override
	public Airport viewAirport(String airportCode) {
		
		return viewAirport(airportCode);
	}

}
