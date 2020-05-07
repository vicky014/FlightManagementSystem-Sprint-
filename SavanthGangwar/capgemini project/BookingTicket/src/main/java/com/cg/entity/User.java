package com.cg.entity;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity(name="user1")
public class User 
{

	@Id
	@SequenceGenerator(name = "mySeqGen", sequenceName = "mySeq", initialValue = 1000)
	@GeneratedValue(generator = "mySeqGen")
	private long id;
	private String booking_date;
	private String travelling_date;
	private int ticket_cost;
	private int passenger_count;	
	private String flight_number;
	private String phone_number;
	private String mail;
	
	@OneToMany(targetEntity=Passenger.class,cascade=CascadeType.ALL)
	@JoinColumn(name="id_fk",referencedColumnName="id")
	private List<Passenger> passengers;
	
	
}
