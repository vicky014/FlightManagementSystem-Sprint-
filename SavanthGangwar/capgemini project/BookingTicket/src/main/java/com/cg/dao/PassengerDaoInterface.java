package com.cg.dao;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.entity.Passenger;

public interface PassengerDaoInterface extends JpaRepository<Passenger,Long>
{

}
