package com.cg.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.entity.Flight;

public interface FlightDaoInterface extends JpaRepository<Flight,String>
{

}
