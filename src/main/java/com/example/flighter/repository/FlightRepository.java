package com.example.flighter.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.flighter.entity.Flight;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer> {

	Flight findByFlightNumber(String flightNumber);
	
}
