package com.cg.controller;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cg.entity.Airport;
import com.cg.entity.Flight;
import com.cg.entity.Schedule;
import com.cg.entity.ScheduledFlight;
import com.cg.exception.FMSException;
import com.cg.service.FMSService;

@CrossOrigin(origins="http://localhost:4200")
@Component
@RestController
public class FMSController {

	@Autowired
	FMSService fmsService;
	
	//Flight
	
		@GetMapping("/flight")
		public List<Flight> viewFlight()
		{
			return fmsService.viewFlight();
		}
		
		@GetMapping(value="/flight/{flightNumber}")//,produces= {"application/json"})
		public Flight viewFlight(@PathVariable String flightNumber) throws FMSException {
			System.out.println("Flight no :"+flightNumber);
			return fmsService.viewFlight(flightNumber);
			
		}
		
		@PostMapping(value="/flight/add",consumes={"application/json"})
		public String addFlight(@RequestBody Flight flight) throws FMSException{
			return fmsService.addFlight(flight);
		}

		@DeleteMapping("/flight/delete/{flightNumber}")
		public String deleteFlight(@PathVariable String flightNumber){
			return fmsService.deleteFlight(flightNumber);
		}
		
		@PutMapping(value="/flight/modify",consumes= {"application/json"})
		public String modifyFlight(@RequestBody Flight flight) throws FMSException{
			return fmsService.modifyFlight(flight);
		}
		
		
		//Airport
		
			@PostMapping(value="/airport/add",consumes= {"application/json"})
			public String addAirport(@RequestBody Airport airport) throws FMSException {
				return fmsService.addAirport(airport);
				
			}
		
			@GetMapping(value="/airport")
			public List<Airport> viewAirport(){
				return fmsService.viewAirport();
			}
			
			@GetMapping(value="/airport/{airportCode}")
			public Airport viewAirport(@PathVariable String airportCode) throws FMSException {
				return fmsService.viewAirport(airportCode);
			}
			

			//ScheduledFlight
			
			@GetMapping("/scheduledFlight")
			public List<ScheduledFlight> viewScheduledFlights(){
				return fmsService.viewScheduledFlights();
			}
			
			@GetMapping(value="/scheduledFlight/{flightNumber}",produces= {"application/json"})
			public ScheduledFlight viewScheduledFlight(@PathVariable String flightNumber) throws FMSException {
				return fmsService.viewScheduledFlight(flightNumber);
			}
			
			@PostMapping(value="/scheduledFlight/add",produces= {"application/json"})
			public String scheduleFlight(@RequestBody ScheduledFlight scheduledFlight) throws FMSException {
				return fmsService.scheduleFlight(scheduledFlight);
			}
			
//			@PutMapping(value="/scheduledFlight/modify",consumes= {"application/json"})
//			public String modifyScheduledFlight(@RequestBody Flight flight,@RequestBody Schedule schedule,String flightNumber) {
//				return fmsService.modifyScheduledFlight(flight, schedule, flightNumber);
//			}
			
			@DeleteMapping(value="/scheduledFlight/delete/{flightNumber}")
			public String deleteScheduledFlight(@PathVariable String flightNumber) {
				return fmsService.deleteFlight(flightNumber);
			}
			
//			//doubt
//			@GetMapping(value="/scheduledFlight/search",produces= {"application/json"})
//			public List<ScheduledFlight> viewScheduledFlights(@RequestBody Airport sourceAirport,@RequestBody Airport destinationAirport,@RequestBody LocalDate arrivalDate){
//				return fmsService.viewScheduledFlights(sourceAirport, destinationAirport, arrivalDate);
//			}
//			
		/*	@GetMapping(value="/scheduledFlight/search",produces= {"application/json"})
			public List<ScheduledFlight> viewScheduledFlights(@RequestBody Airport sourceAirport,@RequestBody Airport destinationAirport,@RequestBody LocalDate arrivalDate){
				return fmsService.viewScheduledFlights(sourceAirport, destinationAirport, arrivalDate);
			}*/
			
//			@GetMapping(value="/scheduledFlight/search/{sourceAirport}/{destinationAirport}/{arrivalDate}",produces= {"application/json"})
//			public List<ScheduledFlight> viewScheduledFlights(@PathVariable String sourceAirport,@PathVariable String destinationAirport,@PathVariable @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate arrivalDate){
//				return fmsService.viewScheduledFlights(sourceAirport, destinationAirport, arrivalDate);
//			}
//			
			//Schedule
			
			@GetMapping("/schedule")
			public List<Schedule> viewAllSchedule(){
				return fmsService.viewAllSchedule();
			}
			
			@GetMapping(value="/schedule/{scheduleId}",produces= {"application/json"})
			public Schedule viewSchedule(@PathVariable String scheduleId) {
				return fmsService.viewSchedule(scheduleId);
			}
//			@PostMapping(value="/schedule/add",produces="{application/json}")
//			public String addSchedule(@RequestBody Schedule s) throws FMSException
//			{
//				return fmsService.addSchedule(s);
//			}
}
