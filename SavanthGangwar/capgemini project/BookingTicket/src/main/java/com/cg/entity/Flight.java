package com.cg.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity(name="flight1")
public class Flight 
{
	@Id
	@GenericGenerator(name="uuid",strategy="uuid2")
	
private String flight_number;
	
	
	private String source;
	
	private String destination;

	private int fare;
	
	private String time;
}
