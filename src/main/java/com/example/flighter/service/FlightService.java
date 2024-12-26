package com.example.flighter.service;

import java.util.List;

import com.example.flighter.entity.Flight;

public interface FlightService {

	public List<Flight> getAllFlights();

	boolean deleteFlightById(Integer id);

	Flight updateFlight(Integer id, Flight updatedFlight);

	Flight addFlight(Flight newFlight);

	Flight getFlightByFlightNumber(String flightNumber);
}
