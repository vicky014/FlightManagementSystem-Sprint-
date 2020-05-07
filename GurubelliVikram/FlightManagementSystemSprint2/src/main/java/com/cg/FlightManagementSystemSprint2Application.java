package com.cg;

import java.time.LocalDate;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cg.dao.FMSDao;

import com.cg.entity.Airport;
import com.cg.entity.Flight;
import com.cg.entity.Schedule;
import com.cg.entity.ScheduledFlight;

@SpringBootApplication
public class FlightManagementSystemSprint2Application implements CommandLineRunner{

	@Autowired
	FMSDao fdao;
	
	public static void main(String[] args) {
		SpringApplication.run(FlightManagementSystemSprint2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println("Welcome");
		

		Flight f=new Flight("200","C1","Vistara",150);
		Flight f1=new Flight("204","B1","AirIndia",100);
		Flight f2=new Flight("205","A1","Indigo",156);
		Flight f3=new Flight("201","D1","Vishal",130);
		Flight f4=new Flight("202","E1","WingAirways",120);
		Flight f5=new Flight("203","F1","IndianAirlines",165);
		
		fdao.addFlight(f);
		fdao.addFlight(f1);
		fdao.addFlight(f2);
		fdao.addFlight(f3);
		fdao.addFlight(f4);
		fdao.addFlight(f5);
		
		
		Airport a=new Airport("VTZ","Vizag Airport","Vishakapatanam");
		Airport a1=new Airport("DEL","IGI Airport","New Delhi");
		Airport a2=new Airport("DUB","Dubai Airport","Dubai");
		Airport a3=new Airport("TOK","Tokyo Airport","Japan");
		Airport a4=new Airport("NYC","New York Airport","New York");
		Airport a5=new Airport("WDC","Washington DC Airport","Washington DC");
		
		fdao.addAirport(a);
		fdao.addAirport(a1);
		fdao.addAirport(a2);
		fdao.addAirport(a3);
		fdao.addAirport(a4);
		fdao.addAirport(a5);
		

		Schedule s=new Schedule("1",a,a1,LocalDate.of(2020, 10, 20),LocalDate.of(2020, 10, 20),"12:15","12:30");
		
		Schedule s1=new Schedule("2",a1,a,LocalDate.of(2020, 11, 21),LocalDate.of(2020, 11, 21),"22:15","22:30");
		Schedule s2=new Schedule("3",a2,a3,LocalDate.of(2020, 12, 21),LocalDate.of(2020, 12, 21),"22:15","22:30");
		Schedule s3=new Schedule("4",a3,a2,LocalDate.of(2020, 10, 20),LocalDate.of(2020, 10, 20),"12:15","12:30");
		
		Schedule s4=new Schedule("5",a4,a5,LocalDate.of(2020, 11, 21),LocalDate.of(2020, 11, 21),"22:15","22:30");
		Schedule s5=new Schedule("6",a5,a4,LocalDate.of(2020, 12, 21),LocalDate.of(2020, 12, 21),"22:15","22:30");
		
//		Schedule s=new Schedule(1,a.getAirportCode(),a1.getAirportCode(),LocalDate.of(2020, 10, 20),LocalDate.of(2020, 10, 20),"12:15","12:30");
//		Schedule s1=new Schedule(2,a1.getAirportCode(),a.getAirportCode(),LocalDate.of(2020, 11, 21),LocalDate.of(2020, 11, 21),"22:15","22:30");
//		
		fdao.addSchedule(s);
		fdao.addSchedule(s1);
		fdao.addSchedule(s2);
		fdao.addSchedule(s3);
		fdao.addSchedule(s4);
		fdao.addSchedule(s5);
//	
		ScheduledFlight sf=new ScheduledFlight(1, f, 20,s);
		ScheduledFlight sf1=new ScheduledFlight(2, f1, 50,s1);
//		ScheduledFlight sf2=new ScheduledFlight(3, f2, 50,s2);
//		ScheduledFlight sf3=new ScheduledFlight(4, f3, 20,s3);
//		ScheduledFlight sf4=new ScheduledFlight(5, f4, 50,s4);
//		ScheduledFlight sf5=new ScheduledFlight(6, f5, 50,s5);
//		
		fdao.scheduleFlight(sf);
		fdao.scheduleFlight(sf1);
//		fdao.scheduleFlight(sf2);
//		fdao.scheduleFlight(sf3);
//		fdao.scheduleFlight(sf4);
//		fdao.scheduleFlight(sf5);
		
	}

}
