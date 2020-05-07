package com.cg.controller;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.dao.FlightDaoInterface;
import com.cg.dao.PassengerDaoInterface;

import com.cg.dao.UserDaoInterface;
import com.cg.dto.BookRequest;
import com.cg.dto.FlightAdd;
import com.cg.entity.Flight;
import com.cg.entity.Passenger;
import com.cg.entity.User;
import com.cg.exception.PassengerException;
import com.cg.service.UserServiceInterface;

@CrossOrigin(origins="http://localhost:4200")

@RestController
public class BookController 
{
	@Autowired
private UserDaoInterface userdao;
	
	@Autowired
	private PassengerDaoInterface passengerdao;
	
	@Autowired
	private FlightDaoInterface flightdao;
	
	@Autowired
	private UserServiceInterface service;
	
	@PostMapping("/add")
	public User addPassenger(@RequestBody BookRequest request ) throws PassengerException, ParseException
	{
		User user=new User();
		Date date=new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
	    String strDate= formatter.format(date); 
		user=userdao.save(request.getUser());
		Optional<Flight> flight=flightdao.findById(user.getFlight_number());
		Flight fli;
				if(flight.isPresent()==true)
				{
					 fli=flight.get();
				}
				else
				{
					throw new PassengerException("FLight number does not exist");
				}
		
		user.setBooking_date(strDate);
		String traveldate=user.getTravelling_date();
		Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(traveldate);

	    System.out.println(fli.getFlight_number());
	
	    
	    if(date1.before(date))
	    {
	    	throw new PassengerException("Travelling date must be after Booking date ");
	    }
	    else
	    {
	    	user.setTravelling_date(traveldate);;
	    }
	    
		int i=user.getPassenger_count();
		if(i>0)
		{
			user.setPassenger_count(i);
		}
		else
		{
			throw new PassengerException("count must be positive");
		}
		user.setTicket_cost(i*fli.getFare());
		
		
		
		
	
		return userdao.save(user);
		
	}
	
	
	@GetMapping("/viewflight")
	public List<Flight> viewFlight()
	{
		return flightdao.findAll();
	}
	
	@GetMapping("/view")
	public List<User> viewticket()
	{
		return userdao.findAll();
	}
	
	@GetMapping("/view/{id}")

	public User getUserData(@PathVariable int id) throws PassengerException 
	{
		return service.viewById(id);
	}
}
