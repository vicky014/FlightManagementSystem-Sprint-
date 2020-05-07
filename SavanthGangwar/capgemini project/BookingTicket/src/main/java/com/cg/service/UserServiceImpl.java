package com.cg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dao.FlightDaoInterface;
import com.cg.dao.PassengerDaoInterface;
import com.cg.dao.UserDaoInterface;
import com.cg.dto.BookRequest;
import com.cg.entity.Flight;
import com.cg.entity.Passenger;
import com.cg.entity.User;
import com.cg.exception.PassengerException;

@Service
public class UserServiceImpl implements UserServiceInterface 
{
	@Autowired
	private UserDaoInterface udao;
	
	@Autowired
	private PassengerDaoInterface pdao;
	
	@Autowired
	private FlightDaoInterface fdao;

	@Override
	public User viewById(long id) throws PassengerException 
	{
		Optional<User> u=udao.findById(id);
		User use;
		if(u.isPresent()==true)
		{
			return u.get();
		}
		else 
		{
			throw new PassengerException("Id does not exist");
		}
		
		
	}

	
	
		
		
	}

	


