package com.cg.dto;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.cg.entity.Passenger;
import com.cg.entity.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class BookRequest 
{
	
	private String booking_date;
	private String travelling_date;
//	private int ticket_cost;
	private int passenger_count;	
	private String flight_number;
	private String phone_number;
	private String mail;
	private User user;
	private Passenger passenger;




}
