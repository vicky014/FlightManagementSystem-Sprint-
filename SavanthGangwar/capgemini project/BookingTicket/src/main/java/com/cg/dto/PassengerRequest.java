package com.cg.dto;

import com.cg.entity.Passenger;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class PassengerRequest 
{
public Passenger passenger;
}
