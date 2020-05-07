package com.cg.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.dto.BookRequest;
import com.cg.entity.Flight;
import com.cg.entity.Passenger;
import com.cg.entity.User;
import com.cg.exception.PassengerException;

@Service
public interface UserServiceInterface 
{
	public User viewById(long id) throws PassengerException ;
}
