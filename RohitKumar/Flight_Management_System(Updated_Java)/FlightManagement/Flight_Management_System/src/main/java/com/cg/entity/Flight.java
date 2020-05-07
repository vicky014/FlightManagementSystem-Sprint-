package com.cg.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="flight1")

public class Flight {
	
	@Id
	private long flightNumber;
	@Column
	private String flightModel;
	@Column
	private int seatCapacity;
	@Column
	private String carrierName;
	
	public Flight() {
		super();
	}
	
	public Flight(long flightNumber, String flightModel, int seatCapacity, String carrierName) {
		super();
		this.flightNumber = flightNumber;
		this.flightModel = flightModel;
		this.seatCapacity = seatCapacity;
		this.carrierName = carrierName;
	}

	public long getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(long flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getFlightModel() {
		return flightModel;
	}

	public void setFlightModel(String flightModel) {
		this.flightModel = flightModel;
	}

	public int getSeatCapacity() {
		return seatCapacity;
	}

	public void setSeatCapacity(int seatCapacity) {
		this.seatCapacity = seatCapacity;
	}

	public String getCarrierName() {
		return carrierName;
	}

	public void setCarrierName(String carrierName) {
		this.carrierName = carrierName;
	}

	@Override
	public String toString() {
		return "Flight [flightNumber=" + flightNumber + ", flightModel=" + flightModel + ", seatCapacity="
				+ seatCapacity + ", carrierName=" + carrierName + "]";
	}
	
	

}
